package com.github.divyuuu.geolocation.service.impl;

import com.github.divyuuu.geolocation.dto.UserResponseDto;
import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.UserRepository;
import com.github.divyuuu.geolocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUser(String email) throws SQLException {
        User user = userRepository.findByEmail(email).orElse(null);
        return user;
    }

    @Override
    public UserResponseDto getUserDto(User user){
        UserResponseDto urd = new UserResponseDto();

        urd.setUuid(user.getUuid());
        urd.setName(user.getName());
        urd.setEmail(user.getEmail());
        urd.setRating(user.getRating());
        urd.setTotalRides(user.getTotalRides());
        urd.setRole(user.getRole());

        return urd;
    }

    @Override
    public User find(UUID uuid) throws SQLException{
        User user = userRepository.findById(uuid).orElse(null);

        return user;
    }
}
