package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Customer;
import java.util.List;

public interface CustomerMapper {
    List<Customer> selectCustomerList();
}
