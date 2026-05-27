package com.github.divyuuu.geolocation.service;

import com.github.divyuuu.geolocation.model.Driver;

import java.util.UUID;

public interface DriverService {
    public Driver find(UUID uuid);
}
