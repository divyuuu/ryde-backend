package com.github.divyuuu.geolocation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.divyuuu.geolocation.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    @JsonProperty("confirmPassword")
    private String password;
    private String email;
    private String name;
    private Role role;
}
