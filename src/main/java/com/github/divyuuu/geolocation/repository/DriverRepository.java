package com.github.divyuuu.geolocation.repository;

import com.github.divyuuu.geolocation.model.Driver;
import com.github.divyuuu.geolocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    public Optional<Driver> findByUser(User user);
}
