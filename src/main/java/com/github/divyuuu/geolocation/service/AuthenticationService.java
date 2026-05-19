package com.github.divyuuu.geolocation.service;


import com.github.divyuuu.geolocation.dto.LoginRequestDto;
import com.github.divyuuu.geolocation.dto.SignUpRequestDto;
import com.github.divyuuu.geolocation.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface AuthenticationService {
    public void signup(SignUpRequestDto request);
    public Optional<User> login(LoginRequestDto request) throws SQLException;
}
