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
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    UserService userService;

    public void create(CarRequestDto req) {
        User user = userService.find(req.getDriverId());
        Driver driver = driverService.findByUser(user);

        if(driver == null){
            throw new RuntimeException("Driver not found for driver id: "+ req.getDriverId());
        }
        Car car = Car.builder()
                .model(req.getModel())
                .brand(req.getBrand())
                .costPerKm(req.getCostPerKm())
                .driver(driver)
                .build();

        List<Car> cars = List.of(car);

        driver.setCars(cars);

        carRepository.save(car);
    }
}
