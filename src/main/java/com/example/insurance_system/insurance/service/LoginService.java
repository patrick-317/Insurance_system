package com.example.insurance_system.insurance.service;


import com.example.insurance_system.DTO.LoginDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final CustomerMapper customerMapper;

    public LoginService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public LoginDTO authenticate(LoginDTO loginRequest) {
        Customer customer = customerMapper.findByIdAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer != null) {
            return new LoginDTO(customer.getId() ,customer.getEmail(), true);
        }else {
            return new LoginDTO("Login Fail", false);
        }
    }
}
