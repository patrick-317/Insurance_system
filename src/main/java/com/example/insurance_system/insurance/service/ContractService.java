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

    public ContractService(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public ContractDTO applyForInsurance(Customer customer, Insurance insurance) {
        validateCustomer(customer);

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

    private void validateCustomer(Customer customer) {
        if (contractDAO.findCustomerById(customer.getId()) == null) {
            throw new IllegalArgumentException("고객 정보를 찾을 수 없습니다.");
        }
    }

    private String mapTypeChoiceToInsuranceType(String typeChoice) {
        switch (typeChoice) {
            case "1": return "생명보험";
            case "2": return "손해보험";
            case "3": return "제3보험";
            default:
                throw new IllegalArgumentException("유효하지 않은 보험 유형입니다.");
        }
    }
}
