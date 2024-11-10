package com.foro.infrastructure.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class LoginDto {

    @Email
    @NotEmpty(message = "El email es obligatorio")
    private String email;

    @NotEmpty(message = "La contraseña es obligatoria")
    private String password;

    public LoginDto(){}

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
