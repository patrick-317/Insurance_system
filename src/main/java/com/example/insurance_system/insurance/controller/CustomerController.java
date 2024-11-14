package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }
}
