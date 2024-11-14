package com.example.insurance_system.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDTO {
    private int customerId;
    private int insuranceId;
    private String contractDate;
    private String status;
}
