package com.example.insurance_system.insurance.service;

import com.example.insurance_system.DTO.InsuranceDTO;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import org.springframework.stereotype.Service;

@Service
public class InsuranceDevelopService {
    private final InsuranceMapper insuranceMapper;

    public InsuranceDevelopService(InsuranceMapper insuranceMapper) {
        this.insuranceMapper = insuranceMapper;
    }

    public String addInsurance(InsuranceDTO insuranceDTO){
        int result = insuranceMapper.addNewInsurance(insuranceDTO);
        if (result>0){
            return "Insurance added successfully";
        }else {
            return "add failed";
        }
    }


}
