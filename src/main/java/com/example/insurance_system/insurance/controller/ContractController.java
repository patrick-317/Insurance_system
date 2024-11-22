package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.DTO.CustomerDTO;
import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/insurance")
    public ResponseEntity<List<Insurance>> getInsuranceList(@RequestBody Map<String, String> requestBody) {
        try {
            String typeName = requestBody.get("type");
            List<Insurance> insuranceList = contractService.getInsuranceListByType(typeName);
            return ResponseEntity.ok(insuranceList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyForInsurance(@RequestBody ContractDTO contractDTO) {
        try {
            CustomerDTO customer = contractDTO.getCustomerDTO();
            int insuranceId = contractDTO.getInsuranceId();

            contractService.applyForInsurance(customer, insuranceId);
            return ResponseEntity.ok("보험 가입요청이 성공적으로 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


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
