package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.dto.LoginRequestDto;
import com.github.divyuuu.geolocation.dto.SignUpRequestDto;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.service.AuthenticationService;
import com.github.divyuuu.geolocation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) throws SQLException {
        Boolean isValid = authenticationService.login(request);

        if(!isValid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error",
                    "Invalid Email or Password"));
        }
        return ResponseEntity.ok(Map.of("success", "succesfully logged in"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequestDto request) throws SQLException {
        String email = request.getEmail();
        if(email == null || email.equals("")){
            return ResponseEntity.badRequest().body("Invalid Email " + email);
        }
        User user = userService.findUser(email);

        if(user != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "User with email " + email + " already exists."));
        }

        authenticationService.signup(request);

        return ResponseEntity.ok(Map.of("success", "User Created Succesfully"));
    }
}
