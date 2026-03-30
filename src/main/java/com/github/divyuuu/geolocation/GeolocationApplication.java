package com.github.divyuuu.geolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeolocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocationApplication.class, args);
		System.out.println("This is working spring boot application");
	}

}
