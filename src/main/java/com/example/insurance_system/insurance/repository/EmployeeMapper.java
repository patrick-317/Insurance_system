package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectEmployeeList();
}