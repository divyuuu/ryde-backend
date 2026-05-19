package com.github.divyuuu.geolocation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.divyuuu.geolocation.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    @JsonProperty("confirmPassword")
    @NotBlank(message = "Password is required.")
    private String password;
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Role is required.")
    private Role role;
}
