package com.example.insurance_system;

import com.example.insurance_system.UI.ContractUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InsuranceSystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InsuranceSystemApplication.class, args);
        ContractUI contractUI = context.getBean(ContractUI.class);
        contractUI.displayMenu();
    }

}
