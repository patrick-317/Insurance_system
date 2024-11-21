package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Crime {
    NO_RECORD("범죄 기록 없음"),
    HAS_RECORD("범죄 기록 존재");

    private final String name;

    Crime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
