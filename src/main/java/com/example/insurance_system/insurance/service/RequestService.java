package com.example.insurance_system.insurance.service;

import com.example.insurance_system.insurance.entity.Request;
import com.example.insurance_system.insurance.repository.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestMapper requestMapper;

    public List<Request> getRequestList() {
        return requestMapper.selectRequestList();
    }
}
