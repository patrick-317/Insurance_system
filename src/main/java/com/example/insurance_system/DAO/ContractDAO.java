package com.example.insurance_system.DAO;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.repository.ContractMapper;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
public class ContractDAO {

    private final ContractMapper contractMapper;
    private final InsuranceMapper insuranceMapper;
    private final CustomerMapper customerMapper;

    public ContractDAO(ContractMapper contractMapper,
                       InsuranceMapper insuranceMapper,
                       CustomerMapper customerMapper) {
        this.contractMapper = contractMapper;
        this.insuranceMapper = insuranceMapper;
        this.customerMapper = customerMapper;
    }

    public void insertContract(ContractDTO contractDTO) {
        contractMapper.insertContract(contractDTO);
    }

    public Customer findCustomerById(int customerId) {
        return customerMapper.findById(customerId);
    }

    public List<Insurance> findInsuranceByType(String type) {
        return insuranceMapper.findByType(type);
    }

    public Insurance findInsuranceById(int insuranceId) {
        return insuranceMapper.findById(insuranceId);
    }

}
