package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import com.example.insurance_system.insurance.repository.ContractMapper;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import com.example.insurance_system.insurance.repository.UnderwritingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnderwritingService {
    private final UnderwritingMapper underwritingMapper;

    public UnderwritingService(UnderwritingMapper underwritingMapper) {
        this.underwritingMapper = underwritingMapper;
    }

    // 계약 승인 메서드
    @Transactional
    public void approveContract(int contractId) {
        Contract contract = underwritingMapper.findById(contractId)
                .orElseThrow(() -> new IllegalArgumentException("Contract not found"));

        if (contract.getContractStatus() == ContractStatus.PENDING) {
            contract.setContractStatus(ContractStatus.ACTIVE); // 승인
            underwritingMapper.updateContract(contract);
        } else {
            throw new IllegalStateException("Contract cannot be approved, current status: " + contract.getContractStatus());
        }
    }

    // 계약 거절 메서드
    @Transactional
    public void rejectContract(int contractId) {
        Contract contract = underwritingMapper.findById(contractId)
                .orElseThrow(() -> new IllegalArgumentException("Contract not found"));

        if (contract.getContractStatus() == ContractStatus.PENDING) {
            contract.setContractStatus(ContractStatus.REJECTED); // 거절
            underwritingMapper.updateContract(contract);
        } else {
            throw new IllegalStateException("Contract cannot be rejected, current status: " + contract.getContractStatus());
        }
    }

    // 모든 PENDING 계약 조회 메서드
    public List<Contract> findPendingContracts() {
        return underwritingMapper.findByContractStatus(ContractStatus.PENDING);
    }
}
