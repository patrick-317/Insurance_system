package com.example.insurance_system.insurance.service;


import com.example.insurance_system.DTO.LoginDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.repository.CustomerMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final CustomerMapper customerMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginService(CustomerMapper customerMapper, BCryptPasswordEncoder passwordEncoder) {
        this.customerMapper = customerMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginDTO authenticate(LoginDTO loginRequest) {
        Customer customer = customerMapper.findByEmail(loginRequest.getEmail());
        if (customer != null && passwordEncoder.matches(loginRequest.getPassword(), customer.getPassword())) {
            return new LoginDTO(customer.getId(), customer.getEmail(), true);
        } else {
            return new LoginDTO("Login Fail", false);
        }
    }
}
