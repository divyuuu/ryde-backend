package com.github.divyuuu.geolocation.controller;

import com.github.divyuuu.geolocation.dto.UserResponseDto;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.service.UserService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/{uuid}")
    public ResponseEntity<?> findUser(@PathVariable("uuid") UUID userId) throws SQLException {
        User user =  userService.find(userId);

        if(user == null){
            throw new RuntimeException("No user found with UUID " + userId);
        }

        UserResponseDto userRes = userService.getUserDto(user);

        return ResponseEntity.ok(Map.of("success", userRes));
    }

}
