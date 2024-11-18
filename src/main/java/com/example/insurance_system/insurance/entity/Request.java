package com.example.insurance_system.insurance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private int id;
    private int customerID;
    private String accidentInfo;
    private String beneficiaryInfo;
    private String bill;
    private String memberInfo;
    private String SSN;
}