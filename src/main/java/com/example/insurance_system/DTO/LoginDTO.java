package com.example.insurance_system.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private int id;
    private String email;
    private String password;
    private String message;
    private boolean success;

    public LoginDTO() {}

    public LoginDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public LoginDTO(int id, String message, boolean success){
        this.id = id;
        this.message = message;
        this.success = success;
    }

    public LoginDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
