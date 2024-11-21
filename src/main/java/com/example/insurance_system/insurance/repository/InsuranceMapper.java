package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.DTO.InsuranceDTO;
import com.example.insurance_system.insurance.entity.Insurance;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface InsuranceMapper {
    List<Insurance> selectInsuranceList();
    List<Insurance> findByType(String type);
    BigDecimal selectPremiumByInsuranceId(Integer insuranceId);
    Insurance findById(int insuranceId);
    Insurance getInsuranceById(Integer insuranceId);

    int addNewInsurance(InsuranceDTO insuranceDTO);
}
