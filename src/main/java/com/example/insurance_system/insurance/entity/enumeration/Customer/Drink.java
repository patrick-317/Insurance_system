package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Drink {
    FREQUENT("잦음"),
    MODERATE("보통"),
    RARE("적음"),
    NONE("없음");

    private final String name;

    Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
