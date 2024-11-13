package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

}
