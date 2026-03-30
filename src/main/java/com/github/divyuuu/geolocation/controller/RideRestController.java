package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.dto.RideRequestDto;
import com.github.divyuuu.geolocation.dto.RideResponseDto;
import com.github.divyuuu.geolocation.model.Ride;
import com.github.divyuuu.geolocation.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ride")
public class RideRestController {
    @Autowired
    RideService rideService;

    @GetMapping
    public ResponseEntity<RideResponseDto> bookRide(@RequestBody RideRequestDto rideReqDto){
        Ride ride = new Ride();
        RideResponseDto response = rideService.bookRide(rideReqDto);

        return ResponseEntity.ok(response);
    }
}
