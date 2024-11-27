package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Mapper
public interface ContractMapper {
    List<Contract> selectContractList();
    public void insertContract(ContractDTO contractDTO);
    boolean checkCustomerInsuranceContract(Integer customerId, Integer insuranceId);
    Contract getContractByCustomerAndInsurance(Integer customerId, Integer insuranceId);
    void insertContract(Contract contract);
    void updateContract(Contract contract);
    void deleteContract(Integer customerId, Integer insuranceId);
    Contract findById(Integer contractId);


}
