package com.example.insurance_system.insurance.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Request {
    private Integer id;
    private Integer customerId;
    private String accidentInfo;
    private String beneficiaryInfo;
    private String bill;
    private String memberInfo;
    private String ssn;
}
