package com.github.divyuuu.geolocation.repository;

import com.github.divyuuu.geolocation.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
