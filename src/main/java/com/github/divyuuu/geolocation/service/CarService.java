package com.github.divyuuu.geolocation.service;

import com.github.divyuuu.geolocation.dto.CarRequestDto;
import com.github.divyuuu.geolocation.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    public void create(CarRequestDto req);
    public List<Car> findAll(UUID userId);
}
