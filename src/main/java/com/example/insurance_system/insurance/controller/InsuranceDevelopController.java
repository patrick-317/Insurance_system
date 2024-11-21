package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.DTO.InsuranceDTO;
import com.example.insurance_system.insurance.service.InsuranceDevelopService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance_develop")
public class InsuranceDevelopController {

    private final InsuranceDevelopService insuranceDevelopService;
    public InsuranceDevelopController(InsuranceDevelopService insuranceDevelopService) {
        this.insuranceDevelopService = insuranceDevelopService;
    }

    @PostMapping("/add")
    public String addInsurance(@RequestBody InsuranceDTO InsuranceDTO){
        return insuranceDevelopService.addInsurance(InsuranceDTO);
    }

}
