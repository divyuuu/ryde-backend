package com.github.divyuuu.geolocation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideResponseDto {
    private String pickup;
    private String destination;
    private String rideType;
    private Double totalFare;
    private Double distance;
    private Integer discount;
    private Integer time;
}
