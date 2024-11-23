package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getCustomerList() {
        return customerMapper.selectCustomerList();
    }
}
