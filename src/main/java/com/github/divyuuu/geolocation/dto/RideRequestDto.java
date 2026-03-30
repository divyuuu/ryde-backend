package com.github.divyuuu.geolocation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideRequestDto {
    private String pickup;
    private String destination;
    private String rideType;
}
