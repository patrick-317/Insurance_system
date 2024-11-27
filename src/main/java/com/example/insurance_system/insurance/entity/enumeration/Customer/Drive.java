package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Drive {
    DRIVER("운전자"),
    NON_DRIVER("비운전자");

    private final String name;

    Drive(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
