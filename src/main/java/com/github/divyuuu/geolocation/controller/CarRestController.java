package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.dto.CarRequestDto;
import com.github.divyuuu.geolocation.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
public class CarRestController {

    @Autowired
    CarService carService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody @Valid CarRequestDto req){
        carService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully added car");
    }
}
