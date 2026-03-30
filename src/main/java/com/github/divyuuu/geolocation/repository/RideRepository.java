package com.github.divyuuu.geolocation.repository;

import com.github.divyuuu.geolocation.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RideRepository extends JpaRepository<Ride, UUID> {
}
