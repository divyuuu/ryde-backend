package com.github.divyuuu.geolocation.service;
import com.github.divyuuu.geolocation.model.User;

import java.sql.SQLException;


public interface UserService{
    public User findUser(String email) throws SQLException ;
}
