package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.DTO.CustomerDTO;
import com.example.insurance_system.insurance.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    Customer findById(int id);

    Customer findByIdAndPassword(@Param("email")String email, @Param("password")String password);

    List<Customer> selectCustomerList();

    void insertCustomer(CustomerDTO customer);
}
