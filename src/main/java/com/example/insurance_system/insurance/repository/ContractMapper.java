package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.DTO.ContractDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractMapper {
    public void insertContract(ContractDTO contractDTO);
}

