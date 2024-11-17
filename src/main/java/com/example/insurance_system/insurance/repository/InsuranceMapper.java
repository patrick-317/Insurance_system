package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Insurance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface InsuranceMapper {
    List<Insurance> selectInsuranceList();
    List<Insurance> findByType(String type);

    Insurance findById(int insuranceId);
}
