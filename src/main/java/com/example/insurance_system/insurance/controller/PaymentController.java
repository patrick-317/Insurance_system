package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.DTO.PaymentDTO;
import com.example.insurance_system.insurance.entity.Payment;
import com.example.insurance_system.insurance.entity.PaymentRequest;
import com.example.insurance_system.insurance.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 보험금 지급 요청 (고객 ID와 보험 ID를 제공하면 지급 금액 자동 조회)
    @PostMapping("/request")
    public Payment requestPayment(@RequestBody PaymentDTO paymentRequest) {
        System.out.println("Received payment request: " + paymentRequest);
        Integer customerId = paymentRequest.getCustomerId();
        Integer insuranceId = paymentRequest.getInsuranceId();
        System.out.println("Received request: customerId=" + customerId + ", insuranceId=" + insuranceId);
        return paymentService.requestPayment(customerId, insuranceId);
    }

    // 보험금 지급 승인
    @PostMapping("/approve/{id}")
    public Payment approvePayment(@PathVariable Integer id) {
        return paymentService.approvePayment(id);
    }

    // 보험금 지급 거절
    @PostMapping("/reject/{id}")
    public Payment rejectPayment(@PathVariable Integer id) {
        return paymentService.rejectPayment(id);
    }

    // 지급 내역 조회
    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }
}
