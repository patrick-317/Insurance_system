package com.example.insurance_system.insurance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Insurance {
    private int id;
    private String name;
    private String description;
    private String premium;
    private String coverage;
    private String term;
    private String maxAge;
    private String exclusions;
}
