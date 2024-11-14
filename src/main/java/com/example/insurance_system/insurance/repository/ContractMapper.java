package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Contract;


public interface ContractMapper {

    boolean checkCustomerInsuranceContract(Integer customerId, Integer insuranceId);

    Contract getContractByCustomerAndInsurance(Integer customerId, Integer insuranceId);

    void insertContract(Contract contract);

    void updateContract(Contract contract);

    void deleteContract(Integer customerId, Integer insuranceId);
}
