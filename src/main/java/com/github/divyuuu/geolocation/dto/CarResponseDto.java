package com.github.divyuuu.geolocation.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDto {
    private UUID id;
    private String brand;
    private String model;
    private Double costPerKm;
    private Boolean available;
}
