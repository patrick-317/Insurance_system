package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Insurance;

import java.math.BigDecimal;
import java.util.List;

public interface InsuranceMapper {
    List<Insurance> selectInsuranceList();
    BigDecimal selectPremiumByInsuranceId(Integer insuranceId);
    Insurance getInsuranceById(Integer insuranceId);
}
