package com.example.insurance_system.insurance.entity.enumeration.Customer;

public enum ContractStatus {
    ACTIVE("활성"),
    PENDING("대기 중"),
    REJECTED("취소됨"),
    EXPIRED("만료됨");

    private final String name;

    ContractStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
