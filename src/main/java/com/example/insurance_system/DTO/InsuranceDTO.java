package com.example.insurance_system.DTO;

import com.example.insurance_system.insurance.entity.enumeration.Insurance.InsuranceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceDTO {
    private int id;
    private String name;
    private String description;
    private String premium;
    private String coverage;
    private String term;
    private int maxAge;
    private String exclusions;
    private InsuranceType insuranceType;
}