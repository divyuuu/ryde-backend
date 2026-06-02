package com.github.divyuuu.geolocation.service;

import com.github.divyuuu.geolocation.model.Car;
import com.github.divyuuu.geolocation.model.Driver;
import com.github.divyuuu.geolocation.model.User;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    public Driver find(UUID uuid);
    public Driver findByUser(User user);
}
