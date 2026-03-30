package com.github.divyuuu.geolocation.service;

import com.github.divyuuu.geolocation.dto.RideRequestDto;
import com.github.divyuuu.geolocation.dto.RideResponseDto;

public interface RideService {
    public RideResponseDto bookRide(RideRequestDto rideReqDto);
}
