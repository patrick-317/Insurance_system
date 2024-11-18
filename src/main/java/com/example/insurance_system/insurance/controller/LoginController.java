package com.example.insurance_system.insurance.controller;



import com.example.insurance_system.DTO.LoginDTO;
import com.example.insurance_system.insurance.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/main")
    public LoginDTO login(@RequestBody LoginDTO loginRequest){
        return loginService.authenticate(loginRequest);
    }

}
