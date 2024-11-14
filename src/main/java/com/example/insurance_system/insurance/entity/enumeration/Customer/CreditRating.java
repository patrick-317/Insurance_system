package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum CreditRating {
    FIRST("1등급"),
    SECOND("2등급"),
    THIRD("3등급"),
    FOURTH("4등급"),
    FIFTH("5등급");

    private final String name;

    CreditRating(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
