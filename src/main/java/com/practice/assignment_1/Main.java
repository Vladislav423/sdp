package com.practice.assignment_1;

import com.practice.assignment_1.builder.CarBuilder;
import com.practice.assignment_1.builder.SportsCarBuilder;
import com.practice.assignment_1.builder.SuvBuilder;
import com.practice.assignment_1.director.CarDirector;
import com.practice.assignment_1.model.Car;

public class Main {

    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        CarBuilder sportsBuilder = new SportsCarBuilder();
        Car sportsCar = director.constructTrackReadySportsCar(sportsBuilder);
        System.out.println("Built by Director: " + sportsCar);

        CarBuilder suvBuilder = new SuvBuilder();
        Car familySuv = director.constructFamilySuv(suvBuilder);
        System.out.println("Built by Director: " + familySuv);

        Car customSportsCar = new SportsCarBuilder()
                .setEngine("Electric Dual-Motor")
                .setSeats(2)
                .setGps(true)
                .setSunroof(false)
                .build();

        System.out.println("Custom build: " + customSportsCar);

        try {
            new SuvBuilder()
                    .setSeats(5)
                    .build();
        } catch (IllegalStateException e) {
            System.err.println(
                    "Expected validation failure: " + e.getMessage()
            );
        }
    }
}