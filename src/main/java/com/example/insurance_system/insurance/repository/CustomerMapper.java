package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    Customer findById(int id);
}

