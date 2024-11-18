package com.example.insurance_system.insurance.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contract {
    private Integer id;            // 계약 ID
    private Integer customerId;    // 고객 ID
    private Integer insuranceId;   // 보험 ID
    private String contractDate;   // 계약 날짜 (String 형식으로 저장)
    private String amount;         // 보험료 (String 형식으로 저장)
    private String status;         // 계약 상태 (예: 'ACTIVE', 'INACTIVE')
}
