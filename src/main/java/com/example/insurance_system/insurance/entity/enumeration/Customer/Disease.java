package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Disease {
    HAS_HISTORY("질병 이력 존재"),
    NO_HISTORY("질병 이력 부재");

    private final String name;

    Disease(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
