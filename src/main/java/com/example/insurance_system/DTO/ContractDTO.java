package com.example.insurance_system.DTO;

import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDTO {
    private int customerId;
    private int insuranceId;
    private String contractDate;
    private String premium;
    private String contractStatus;

    private CustomerDTO customerDTO;
}
