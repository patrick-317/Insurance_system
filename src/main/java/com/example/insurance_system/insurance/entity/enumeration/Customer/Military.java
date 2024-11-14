package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Military {
    COMPLETED("군필"),
    EXEMPTED("면제"),
    NONE("미필");

    private final String name;

    Military(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
