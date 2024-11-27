package com.example.insurance_system.insurance.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class Payment {
    private Integer id;
    private Integer customerId;
    private Integer insuranceId;
    private String amount;
    private String paymentDate;
    private String status;  // 'PENDING', 'APPROVED', 'REJECTED'
}
