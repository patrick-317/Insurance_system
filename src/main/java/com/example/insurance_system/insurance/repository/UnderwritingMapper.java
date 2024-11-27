package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UnderwritingMapper {

    List<Contract> findByContractStatus(ContractStatus contractStatus);

    Optional<Contract> findById(int contractId);

    void updateContract(Contract contract);
}
