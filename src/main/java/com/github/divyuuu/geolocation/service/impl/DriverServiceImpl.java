package com.github.divyuuu.geolocation.service.impl;

import com.github.divyuuu.geolocation.model.Driver;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DriverServiceImpl {

    @Autowired
    DriverRepository driverRepository;

    public Driver find(UUID uuid){
        return driverRepository.findById(uuid).orElse(null);
    }

    public Driver findByUser(User user){ return driverRepository.findByUser(user).orElse(null); }
}
