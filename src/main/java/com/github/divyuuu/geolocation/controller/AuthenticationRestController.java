package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.dto.LoginRequestDto;
import com.github.divyuuu.geolocation.dto.SignupRequestDto;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.service.AuthenticationService;
import com.github.divyuuu.geolocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto request) throws SQLException {

        User user = userService.findUser(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body(false);
        }

        boolean isValid = user.getPassword().equals(request.getPassword());

        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setRating(0.0);
        user.setTotalRides(0);
        authenticationService.signup(user);
        return "sign up done";
    }
}
