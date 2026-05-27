package com.github.divyuuu.geolocation.service.impl;

import com.github.divyuuu.geolocation.dto.CarRequestDto;
import com.github.divyuuu.geolocation.model.Car;
import com.github.divyuuu.geolocation.model.Driver;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.CarRepository;
import com.github.divyuuu.geolocation.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverServiceImpl driverService;

    public void create(CarRequestDto req) {
        Driver driver = driverService.find(req.getDriverId());

        if(driver == null){
            throw new RuntimeException("Driver not found for driver id: "+ req.getDriverId());
        }
        Car car = Car.builder()
                .model(req.getModel())
                .brand(req.getBrand())
                .costPerKm(req.getCostPerKm())
                .driver(driver)
                .build();

        driver.setCar(car);
    }
}
