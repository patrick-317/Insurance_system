package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.dto.LoginDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private CustomerMapper customerMapper;

    public LoginDTO authenticate(LoginDTO loginRequest) {
        Customer customer = customerMapper.findByIdAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer != null) {
            return new LoginDTO("Login Success", true);
        }else {
            return new LoginDTO("Login Fail", false);
        }
    }
}
