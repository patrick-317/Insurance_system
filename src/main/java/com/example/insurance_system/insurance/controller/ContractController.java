package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    // 고객과 보험에 대한 계약 조회
    @GetMapping("/{customerId}/{insuranceId}")
    public Contract getContract(@PathVariable Integer customerId, @PathVariable Integer insuranceId) {
        return contractService.getContractByCustomerAndInsurance(customerId, insuranceId);
    }

    // 계약 저장
    @PostMapping
    public void saveContract(@RequestBody Contract contract) {
        contractService.saveContract(contract);
    }

    // 계약 수정
    @PutMapping
    public void updateContract(@RequestBody Contract contract) {
        contractService.updateContract(contract);
    }

    // 계약 삭제
    @DeleteMapping("/{customerId}/{insuranceId}")
    public void deleteContract(@PathVariable Integer customerId, @PathVariable Integer insuranceId) {
        contractService.deleteContract(customerId, insuranceId);
    }
}
