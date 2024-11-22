package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.service.ContractService;
import com.example.insurance_system.insurance.service.UnderwritingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/underwriting")
public class UnderwritingController {
    private final UnderwritingService underwritingService;

    public UnderwritingController(UnderwritingService underwritingService) {
        this.underwritingService = underwritingService;
    }
    // 계약 승인
    @PutMapping("/approve/{contractId}")
    public void approveContract(@PathVariable int contractId) {
        underwritingService.approveContract(contractId);
    }

    // 계약 거절
    @PutMapping("/reject/{contractId}")
    public void rejectContract(@PathVariable int contractId) {
        underwritingService.rejectContract(contractId);
    }

    // PENDING 계약 조회
    @GetMapping("/pending")
    public List<Contract> getPendingContracts() {
        return underwritingService.findPendingContracts();
    }
}
