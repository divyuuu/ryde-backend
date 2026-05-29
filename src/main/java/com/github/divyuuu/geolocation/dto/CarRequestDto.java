package com.github.divyuuu.geolocation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {
    @NotBlank(message = "car brand name is required")
    private String brand;
    @NotBlank(message = "car model name is required")
    private String model;
    @NotNull(message = "car cost per km is required")
    private Double costPerKm;
    @NotNull(message = "driver id is needed to add a car")
    private UUID driverId;
}
