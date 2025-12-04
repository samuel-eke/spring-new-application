package com.samuelaptech.newstore.dto;

import lombok.Data;

@Data
public class ChangePasswordRequestDTO {
    private String oldPassword;
    private String newPassword;
}
