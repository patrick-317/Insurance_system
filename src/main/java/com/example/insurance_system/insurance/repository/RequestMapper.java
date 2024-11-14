package com.example.insurance_system.insurance.repository;

import com.example.insurance_system.insurance.entity.Request;
import java.util.List;

public interface RequestMapper {
    List<Request> selectRequestList();
}
