package com.samuelaptech.newstore.dto;

import lombok.Data;

@Data
public class RegisterUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
