package com.example.insurance_system.DTO;

import com.example.insurance_system.insurance.entity.enumeration.Customer.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private int id;
    private String password;
    private String customerNumber;
    private String name;
    private int age;
    private String account;
    private String address;
    private String phoneNumber;
    private String job;
    private String email;
    private String birthdate;
    private String identityNum;
    private Gender gender;
    private CreditRating creditRating;
    private Abroad abroad;
    private ContractStatus contractStatus;
    private Crime crime;
    private Disease disease;
    private Drink drink;
    private Drive drive;
    private Military military;

}
