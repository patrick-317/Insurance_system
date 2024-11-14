package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Employee;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeList();
}
