package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.Payment;
import com.example.insurance_system.insurance.repository.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private ContractService contractService; // 계약 서비스 주입 (보험금 지급 시 계약 정보 필요)

    // 보험금 지급 요청 (고객 ID와 보험 ID를 제공하면 지급 금액 자동 조회)
    public Payment requestPayment(Integer customerId, Integer insuranceId) {
        // 고객과 보험에 대한 계약이 존재하는지 확인
        Contract contract = contractService.getContractByCustomerAndInsurance(customerId, insuranceId);
        if (contract == null) {
            throw new RuntimeException("No contract found for the customer and insurance.");
        }

        // 지급 금액 계산 (보험료를 기반으로 지급 금액 계산)
        String premium = contract.getAmount(); // 계약에서 금액 가져오기
        if (premium == null || premium.isEmpty()) {
            throw new RuntimeException("Premium amount is invalid.");
        }

        // 지급 요청 생성
        Payment payment = new Payment();
        payment.setCustomerId(customerId);
        payment.setInsuranceId(insuranceId);
        payment.setAmount(premium); // 보험료를 그대로 String으로 설정
        payment.setStatus("REQUESTED");

        // 지급 요청 저장
        paymentMapper.insertPayment(payment);

        return payment;
    }

    // 보험금 지급 승인
    public Payment approvePayment(Integer id) {
        Payment payment = paymentMapper.selectPaymentById(id);
        if (payment == null) {
            throw new RuntimeException("Payment not found.");
        }

        // 상태 업데이트: 승인
        payment.setStatus("APPROVED");

        // 지급 승인 업데이트
        paymentMapper.updatePayment(payment);

        return payment;
    }

    // 보험금 지급 거절
    public Payment rejectPayment(Integer id) {
        Payment payment = paymentMapper.selectPaymentById(id);
        if (payment == null) {
            throw new RuntimeException("Payment not found.");
        }

        // 상태 업데이트: 거절
        payment.setStatus("REJECTED");

        // 지급 거절 업데이트
        paymentMapper.updatePayment(payment);

        return payment;
    }

    // 지급 내역 조회
    public List<Payment> getPayments() {
        return paymentMapper.selectAllPayments();
    }
}
