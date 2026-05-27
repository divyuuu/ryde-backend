package com.github.divyuuu.geolocation.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brand;
    private String model;
    private Double costPerKm;
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "driver", unique = true)
    private Driver driver;

    @PrePersist
    protected void onCreate(){
        if(available == null){
            this.available = true;
        }
    }
}
