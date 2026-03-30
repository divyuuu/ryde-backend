package com.github.divyuuu.geolocation.repository;
import com.github.divyuuu.geolocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {
    public Optional<User> findByEmail(String email);
}
