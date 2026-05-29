package com.github.divyuuu.geolocation.service;
import com.github.divyuuu.geolocation.dto.UserResponseDto;
import com.github.divyuuu.geolocation.model.User;

import java.sql.SQLException;
import java.util.UUID;


public interface UserService{
    public User findUser(String email);
    public UserResponseDto getUserDto(User user);
    public User find(UUID uuid);
}
