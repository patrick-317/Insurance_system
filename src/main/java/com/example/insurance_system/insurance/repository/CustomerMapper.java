package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> getCustomerList();
    Customer findByIdAndPassword(@Param("email")String email, @Param("password")String password);
}
