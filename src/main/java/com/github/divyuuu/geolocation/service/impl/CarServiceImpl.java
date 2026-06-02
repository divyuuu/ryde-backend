package com.github.divyuuu.geolocation.service.impl;

import com.github.divyuuu.geolocation.dto.CarRequestDto;
import com.github.divyuuu.geolocation.model.Car;
import com.github.divyuuu.geolocation.model.Driver;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.CarRepository;
import com.github.divyuuu.geolocation.service.CarService;
import com.github.divyuuu.geolocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    UserService userService;

    public void create(CarRequestDto req) {
        User user = userService.find(req.getUserId());
        Driver driver = driverService.findByUser(user);

        if(driver == null){
            throw new RuntimeException("Driver not found for driver id: "+ req.getUserId());
        }
        Car car = Car.builder()
                .model(req.getModel())
                .brand(req.getBrand())
                .costPerKm(req.getCostPerKm())
                .driver(driver)
                .build();

        carRepository.save(car);
    }

    @Override
    public List<Car> findAll(UUID userId) {
        User user = userService.find(userId);
        if (user == null){
            throw new IllegalArgumentException("No user found for User id: "+ userId);
        }

        UUID driverId = user.getDriver().getUuid();
        if(driverId == null){
            throw new IllegalArgumentException("No driver found for user id: " + userId);
        }

        Driver driver = driverService.find(driverId);
        List<Car> cars = carRepository.findAllByDriver(driver);

        return cars;
    }
}
