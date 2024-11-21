package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.repository.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranceMapper insuranceMapper;
    public List<Insurance> getAllInsurance(){
        return insuranceMapper.selectInsuranceList();
    }

    // 보험의 premium (보험료) 정보를 가져오기
    public String getInsurancePremium(Integer insuranceId) {
        Insurance insurance = insuranceMapper.getInsuranceById(insuranceId);
        if (insurance != null) {
            return insurance.getPremium();
        } else {
            throw new RuntimeException("보험 정보가 존재하지 않습니다.");
        }
    }
}