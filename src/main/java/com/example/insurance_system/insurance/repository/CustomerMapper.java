package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {
    Customer findById(int id);

    Customer findByIdAndPassword(@Param("email")String email, @Param("password")String password);

}

