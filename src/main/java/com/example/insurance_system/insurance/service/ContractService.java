package com.example.insurance_system.insurance.service;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.entity.enumeration.Insurance.InsuranceType;
import com.example.insurance_system.insurance.repository.ContractMapper;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ContractService(ContractMapper contractMapper,
                           InsuranceMapper insuranceMapper, CustomerMapper customerMapper) {
        this.contractMapper = contractMapper;
        this.insuranceMapper = insuranceMapper;
        this.customerMapper = customerMapper;
    }
    @Transactional
    public void applyForInsurance(Customer customer, int insuranceId) {
        Insurance insurance = findInsuranceById(insuranceId);
        customerMapper.insertCustomer(customer);

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCustomerId(customer.getId());
        contractDTO.setInsuranceId(insurance.getId());
        contractDTO.setContractDate(java.time.LocalDate.now().toString());
        contractDTO.setPremium(insurance.getPremium());
        contractMapper.insertContract(contractDTO);
    }

    public List<Insurance> getInsuranceListByType(String typeChoice) {
        InsuranceType insuranceType = typeChoiceToInsuranceType(typeChoice);
        String insuranceTypeName = insuranceType.getName();
        return insuranceMapper.findByType(insuranceTypeName);
    }


    public Insurance findInsuranceById(int insuranceId) {
        Insurance insurance = insuranceMapper.findById(insuranceId);
        if (insurance == null) {
            throw new IllegalArgumentException("해당 ID의 보험이 존재하지 않습니다.");
        }
        return insurance;
    }

    private InsuranceType typeChoiceToInsuranceType(String typeChoice) {
        switch (typeChoice) {
            case "1": return LIFE_INSURANCE;
            case "2": return DAMAGE_INSURANCE;
            case "3": return THIRD_INSURANCE;
            default:
                throw new IllegalArgumentException("유효하지 않은 보험 유형입니다.");
        }
    }

//    @Autowired
//    private ContractMapper contractMapper;

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
            contract.setPremium(premium); // 보험료를 계약 금액으로 설정
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
