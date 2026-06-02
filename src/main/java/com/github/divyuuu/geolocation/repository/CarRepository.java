package com.github.divyuuu.geolocation.repository;

import com.github.divyuuu.geolocation.model.Car;
import com.github.divyuuu.geolocation.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    public List<Car> findAllByDriver(Driver driver);
}
