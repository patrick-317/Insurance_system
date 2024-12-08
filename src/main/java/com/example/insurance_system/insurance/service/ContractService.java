package com.example.insurance_system.insurance.service;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.DTO.CustomerDTO;
import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.entity.enumeration.Customer.ContractStatus;
import com.example.insurance_system.insurance.entity.enumeration.Insurance.InsuranceType;
import com.example.insurance_system.insurance.repository.ContractMapper;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.insurance_system.insurance.entity.enumeration.Insurance.InsuranceType.*;

@Service
public class ContractService {

    private final ContractMapper contractMapper;
    private final InsuranceMapper insuranceMapper;
    private final CustomerMapper customerMapper;

    private final SqlSessionFactory replicaSqlSessionFactory;

    @Autowired
    public ContractService(
            ContractMapper contractMapper,
            InsuranceMapper insuranceMapper,
            CustomerMapper customerMapper,
            @Qualifier("replicaSqlSessionFactory") SqlSessionFactory replicaSqlSessionFactory) {
        this.contractMapper = contractMapper;
        this.insuranceMapper = insuranceMapper;
        this.customerMapper = customerMapper;
        this.replicaSqlSessionFactory = replicaSqlSessionFactory;
    }

    @Transactional
    public void applyForInsurance(CustomerDTO customer, int insuranceId) {
        Insurance insurance = findInsuranceById(insuranceId);
        customerMapper.insertCustomer(customer);

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCustomerId(customer.getId());
        contractDTO.setInsuranceId(insurance.getId());
        contractDTO.setContractDate(java.time.LocalDate.now().toString());
        contractDTO.setPremium(insurance.getPremium());
        contractMapper.insertContract(contractDTO);
    }

    public List<Insurance> getInsuranceListByType(String typeName) {
        try (SqlSession sqlSession = replicaSqlSessionFactory.openSession()) {
            InsuranceMapper mapper = sqlSession.getMapper(InsuranceMapper.class);
            return mapper.findByType(typeName);
        }
    }

    public Insurance findInsuranceById(int insuranceId) {
        Insurance insurance = insuranceMapper.findById(insuranceId);
        if (insurance == null) {
            throw new IllegalArgumentException("해당 ID의 보험이 존재하지 않습니다.");
        }
        return insurance;
    }

    public boolean checkCustomerInsuranceContract(Integer customerId, Integer insuranceId) {
        return contractMapper.checkCustomerInsuranceContract(customerId, insuranceId);
    }

    public Contract getContractByCustomerAndInsurance(Integer customerId, Integer insuranceId) {
        Contract contract = contractMapper.getContractByCustomerAndInsurance(customerId, insuranceId);

        if (contract != null) {
            String premium = contract.getPremium();
            contract.setPremium(premium);
        }

        return contract;
    }

    public void saveContract(Contract contract) {
        contractMapper.insertContract(contract);
    }

    public void updateContract(Contract contract) {
        contractMapper.updateContract(contract);
    }

    public void deleteContract(Integer customerId, Integer insuranceId) {
        contractMapper.deleteContract(customerId, insuranceId);
    }
}