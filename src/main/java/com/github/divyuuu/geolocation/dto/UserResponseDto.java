package com.github.divyuuu.geolocation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private UUID uuid;
    private String email;
    private String name;
    private Double rating;
    private Integer totalRides;
}
