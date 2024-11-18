package com.example.insurance_system.insurance.service;

import com.example.insurance_system.DAO.ContractDAO;
import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Contract;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.repository.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractDAO contractDAO;

    private static final String LIFE_INSURANCE = "생명보험";
    private static final String DAMAGE_INSURANCE = "손해보험";
    private static final String THIRD_INSURANCE = "제3보험";

    public ContractService(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public ContractDTO applyForInsurance(Customer customer, Insurance insurance) {
        validateCustomerById(customer.getId());

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCustomerId(customer.getId());
        contractDTO.setInsuranceId(insurance.getId());
        contractDTO.setContractDate(java.time.LocalDate.now().toString());
        contractDTO.setStatus("PENDING");

        contractDAO.insertContract(contractDTO);
        return contractDTO;
    }

    public List<Insurance> getInsuranceListByType(String typeChoice) {
        String insuranceType = mapTypeChoiceToInsuranceType(typeChoice);
        return contractDAO.findInsuranceByType(insuranceType);
    }

    public Customer findCustomerById(int customerId) {
        Customer customer = contractDAO.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("해당 ID의 고객이 존재하지 않습니다.");
        }
        return customer;
    }
    public Insurance findInsuranceById(int insuranceId) {
        Insurance insurance = contractDAO.findInsuranceById(insuranceId);
        if (insurance == null) {
            throw new IllegalArgumentException("해당 ID의 보험이 존재하지 않습니다.");
        }
        return insurance;
    }

    private void validateCustomerById(int customerId) {
        if (contractDAO.findCustomerById(customerId) == null) {
            throw new IllegalArgumentException("고객 정보를 찾을 수 없습니다.");
        }
    }

    private String mapTypeChoiceToInsuranceType(String typeChoice) {
        switch (typeChoice) {
            case "1":
                return LIFE_INSURANCE;
            case "2":
                return DAMAGE_INSURANCE;
            case "3":
                return THIRD_INSURANCE;
            default:
                throw new IllegalArgumentException("유효하지 않은 보험 유형입니다.");
        }
    }

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
