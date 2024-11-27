package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum Gender {
    MALE("남성"),
    FEMALE("여성");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
