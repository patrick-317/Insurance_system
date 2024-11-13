package com.example.insurance_system.insurance.controller;


import com.example.insurance_system.insurance.dto.LoginDTO;
import com.example.insurance_system.insurance.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/main")
    public LoginDTO login(@RequestBody LoginDTO loginRequest){
        return loginService.authenticate(loginRequest);
    }

}
