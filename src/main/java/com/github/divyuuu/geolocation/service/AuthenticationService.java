package com.github.divyuuu.geolocation.service;


import com.github.divyuuu.geolocation.dto.LoginRequestDto;
import com.github.divyuuu.geolocation.dto.SignUpRequestDto;

import java.sql.SQLException;

public interface AuthenticationService {
    public void signup(SignUpRequestDto request);
    public Boolean login(LoginRequestDto request) throws SQLException;
}
