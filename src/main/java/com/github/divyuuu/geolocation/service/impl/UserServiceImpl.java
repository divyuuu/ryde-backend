package com.github.divyuuu.geolocation.service.impl;

import com.github.divyuuu.geolocation.model.User;
import com.github.divyuuu.geolocation.repository.UserRepository;
import com.github.divyuuu.geolocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUser(String email) throws SQLException {
        User user = userRepository.findByEmail(email).orElse(null);
        return user;
    }
}
