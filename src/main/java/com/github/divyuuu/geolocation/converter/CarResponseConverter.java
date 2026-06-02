package com.github.divyuuu.geolocation.converter;

import com.github.divyuuu.geolocation.dto.CarResponseDto;
import com.github.divyuuu.geolocation.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarResponseConverter {

    public List<CarResponseDto> convert(List<Car> cars){
        List<CarResponseDto> carRes = new ArrayList<CarResponseDto>();

        for(Car car: cars){
            CarResponseDto currCarRes = CarResponseDto.builder()
                    .id(car.getId())
                    .available(car.getAvailable())
                    .model(car.getModel())
                    .brand(car.getBrand())
                    .costPerKm(car.getCostPerKm())
                    .build();

            carRes.add(currCarRes);
        }

        return carRes;
    }
}
