package com.example.insurance_system.insurance.service;

import com.example.insurance_system.DAO.ContractDAO;
import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
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
            case "1": return LIFE_INSURANCE;
            case "2": return DAMAGE_INSURANCE;
            case "3": return THIRD_INSURANCE;
            default:
                throw new IllegalArgumentException("유효하지 않은 보험 유형입니다.");
        }
    }
}
