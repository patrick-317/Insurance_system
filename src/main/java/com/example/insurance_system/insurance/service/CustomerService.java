package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    public List<Customer> getAllCustomer() {
        return customerMapper.getCustomerList();
    }

}
