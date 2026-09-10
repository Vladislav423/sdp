package com.practice.assignment_1.director;

import com.practice.assignment_1.builder.CarBuilder;
import com.practice.assignment_1.model.Car;

public class CarDirector {
    public Car constructTrackReadySportsCar(CarBuilder builder) {
        return builder.setEngine("V8 4.0L Twin-Turbo")
                .setSeats(2)
                .setGps(true)
                .setSunroof(false)
                .build();
    }

    public Car constructFamilySuv(CarBuilder builder) {
        return builder.setEngine("3.0L Turbo Diesel")
                .setSeats(7)
                .setGps(true)
                .setSunroof(true)
                .build();
    }
}
