package com.github.divyuuu.geolocation.service.impl;


import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.divyuuu.geolocation.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    UserRepository userRepository;

    @Override
    public String signup(User user){
        userRepository.save(user);

        return "";
    }
}
