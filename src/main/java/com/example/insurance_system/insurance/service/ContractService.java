package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.repository.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    @Lazy
    private InsuranceService insuranceService;

    // 계약 여부 확인
    public boolean checkCustomerInsuranceContract(Integer customerId, Integer insuranceId) {
        return contractMapper.checkCustomerInsuranceContract(customerId, insuranceId);
    }

    // 계약 정보 조회 후 보험료에 따른 금액 설정
    public Contract getContractByCustomerAndInsurance(Integer customerId, Integer insuranceId) {
        Contract contract = contractMapper.getContractByCustomerAndInsurance(customerId, insuranceId);

        if (contract != null) {
            // 보험료를 가져와서 계약 금액을 설정
            String premium = insuranceService.getInsurancePremium(insuranceId);
            contract.setAmount(premium); // 보험료를 계약 금액으로 설정
        }

        return contract;
    }

    // 계약 저장
    public void saveContract(Contract contract) {
        contractMapper.insertContract(contract);
    }

    // 계약 업데이트
    public void updateContract(Contract contract) {
        contractMapper.updateContract(contract);
    }

    // 계약 삭제
    public void deleteContract(Integer customerId, Integer insuranceId) {
        contractMapper.deleteContract(customerId, insuranceId);
    }
}
