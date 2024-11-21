package com.example.insurance_system.insurance.entity.enumeration.Insurance;

public enum InsuranceType {
    LIFE_INSURANCE("생명보험"),
    DAMAGE_INSURANCE("손해보험"),
    THIRD_INSURANCE("제3보험");

    private final String name;

    InsuranceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
