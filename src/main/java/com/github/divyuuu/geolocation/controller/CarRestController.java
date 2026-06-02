package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.converter.CarResponseConverter;
import com.github.divyuuu.geolocation.dto.CarRequestDto;
import com.github.divyuuu.geolocation.dto.CarResponseDto;
import com.github.divyuuu.geolocation.model.Car;
import com.github.divyuuu.geolocation.service.CarService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/car")
public class CarRestController {

    @Autowired
    CarService carService;

    @Autowired
    CarResponseConverter carResponseConverter;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody @Valid CarRequestDto req){
        carService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully added car");
    }

    @GetMapping("/{userId}")
    private ResponseEntity<?> findAll(@PathVariable(value = "userId") UUID userId){
        List<Car> cars = carService.findAll(userId);

        if(cars == null){
            cars = new ArrayList<>();
        }

        List<CarResponseDto> carRes = carResponseConverter.convert(cars);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("cars", carRes));
    }
}
