package com.samuelaptech.newstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @JsonProperty("user_id")
    private Long id;
    @JsonProperty("patient_name")
    private String name;
    @JsonProperty("company_email")
    private String email;
    private String gender;
    private String phoneNumber;
    private String nationality;

}
