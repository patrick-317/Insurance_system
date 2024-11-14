package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public List<Insurance> getInsuranceList() {
        return insuranceService.getInsuranceList();
    }
}
