package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaymentMapper {

    // 보험금 지급 요청 저장
    void insertPayment(Payment payment);

    // 지급 내역 조회 (모든 지급 내역)
    List<Payment> selectAllPayments();

    // 지급 내역 조회 (ID로 지급 내역 조회)
    Payment selectPaymentById(Integer id);

    // 지급 내역 상태 업데이트 (승인/거절)
    void updatePayment(Payment payment);
}
