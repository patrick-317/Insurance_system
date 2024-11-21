package com.example.insurance_system.insurance.controller;

import com.example.insurance_system.insurance.entity.Request;
import com.example.insurance_system.insurance.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> getRequestList() {
        return requestService.getRequestList();
    }
}
