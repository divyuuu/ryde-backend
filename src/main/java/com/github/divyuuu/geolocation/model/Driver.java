package com.github.divyuuu.geolocation.model;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private String vehicleNumber;
    private String vehicleModel;
    private String licenseNumber;
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
