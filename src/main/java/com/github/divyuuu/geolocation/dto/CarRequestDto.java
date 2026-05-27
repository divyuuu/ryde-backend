package com.github.divyuuu.geolocation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CarRequestDto {
    @NotBlank(message = "car brand name is required")
    private String brand;
    @NotBlank(message = "car model name is required")
    private String model;
    @NotBlank(message = "car cost per km is required")
    private Double costPerKm;
    @NotBlank(message = "driver id is needed to add a car")
    private UUID driverId;
}
