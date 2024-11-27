package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.service.RequestAccidentInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/requestInvestment")
public class RequestAccidentInvestmentController {
    private final RequestAccidentInvestmentService requestAccidentInvestmentService;

    @Autowired
    public RequestAccidentInvestmentController(RequestAccidentInvestmentService requestAccidentInvestmentService) {
        this.requestAccidentInvestmentService = requestAccidentInvestmentService;
    }

    // 계약 목록 조회
    @GetMapping("/contracts")
    public List<Contract> getAllContracts(){
        return requestAccidentInvestmentService.getAllContracts();
    }

    // 특정 계약 사고 조사 요청
    @PostMapping("/contracts/{contractId}/request")
    public String requestAccidentInvestigation(@PathVariable Integer contractId) {
        boolean success = requestAccidentInvestmentService.requestAccidentInvestigation(contractId);
        return success ? "사고 조사 요청이 성공적으로 처리되었습니다." : "사고 조사 요청에 실패하였습니다.";
    }

}
