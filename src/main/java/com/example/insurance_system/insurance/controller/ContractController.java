package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/insurance")
    public ResponseEntity<List<Insurance>> getInsuranceList(@RequestParam String typeChoice) {
        try {
            List<Insurance> insuranceList = contractService.getInsuranceListByType(typeChoice);
            return ResponseEntity.ok(insuranceList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyForInsurance(@RequestParam int customerId, @RequestParam int insuranceId) {
        try {
            Customer customer = contractService.findCustomerById(customerId);
            Insurance insurance = contractService.findInsuranceById(insuranceId);
            ContractDTO contractDTO = contractService.applyForInsurance(customer, insurance);
            return ResponseEntity.ok("보험 계약이 성공적으로 생성되었습니다. 상태: " + contractDTO.getStatus());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
