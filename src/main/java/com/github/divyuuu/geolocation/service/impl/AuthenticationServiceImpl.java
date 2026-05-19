package com.github.divyuuu.geolocation.service.impl;


import com.github.divyuuu.geolocation.dto.LoginRequestDto;
import com.github.divyuuu.geolocation.dto.SignUpRequestDto;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.UserRepository;
import com.github.divyuuu.geolocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.divyuuu.geolocation.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Override
    public void signup(SignUpRequestDto request){
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());

        String rawPassword = request.getPassword();
        String encryptedPassword = passwordEncoder.encode(rawPassword);
        newUser.setPassword(encryptedPassword);

        newUser.setRole(request.getRole());
        newUser.setRating(0.0);
        newUser.setTotalRides(0);

        userRepository.save(newUser);

    }

    @Override
    public Optional<User> login(LoginRequestDto request) throws SQLException {
        User user = userService.findUser(request.getEmail());

        if(user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return Optional.of(user);
        }

        return Optional.empty();
    }
}
