package com.github.divyuuu.geolocation.service;

import com.github.divyuuu.geolocation.dto.SignupRequestDto;
import com.github.divyuuu.geolocation.model.User;


public interface AuthenticationService {
    public String signup(User user);
}
