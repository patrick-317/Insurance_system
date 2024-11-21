package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Employee;
import com.example.insurance_system.insurance.repository.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmployeeList() {
        return employeeMapper.selectEmployeeList();
    }
}
