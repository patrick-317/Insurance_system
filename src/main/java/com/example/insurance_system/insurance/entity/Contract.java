package com.example.insurance_system.insurance.entity;

import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Contract {
    private Integer id;            // 계약 ID
    private Integer customerId;    // 고객 ID
    private Integer insuranceId;   // 보험 ID
    private String contractDate;   // 계약 날짜 (String 형식으로 저장)
    private String premium;         // 보험료 (String 형식으로 저장)
    private ContractStatus contractStatus;
}
