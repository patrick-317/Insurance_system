package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Abroad {
    DOMESTIC("국내 거주"),
    ABROAD("해외 거주");

    private final String name;

    Abroad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

