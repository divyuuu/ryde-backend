package com.github.divyuuu.geolocation.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private String pickup;
    private String destination;
    private String rideType;
    private Double distance;
    private Double fare;
    private Time time;
}
