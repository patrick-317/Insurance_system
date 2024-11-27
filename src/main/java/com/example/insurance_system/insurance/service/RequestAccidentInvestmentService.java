package com.example.insurance_system.insurance.service;


import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.repository.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RequestAccidentInvestmentService {

    private final ContractMapper contractMapper;

    @Autowired
    public RequestAccidentInvestmentService(ContractMapper contractMapper) {
        this.contractMapper = contractMapper;
    }
    // contract 계약 조회
    public List<Contract> getAllContracts() {
        return contractMapper.selectContractList();
    }
    // 특정 계약의 사고 조사 요청
    public boolean requestAccidentInvestigation(Integer contractId) {
        Contract contract = contractMapper.findById(contractId);
        if (contract != null) {
            return true;
        }else {
            return false;
        }
    }
}
