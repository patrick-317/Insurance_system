package com.example.insurance_system.insurance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Complaint {
    private int customerID;
    private int employeeID;
    private String customerInfo;
    private String date;
    private String department;
    private String details;
    private String title;
}
