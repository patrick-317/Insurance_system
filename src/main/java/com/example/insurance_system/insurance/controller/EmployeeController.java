package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Employee;
import com.example.insurance_system.insurance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
