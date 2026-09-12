package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;
import com.practice.assignment_1.model.CarType;

public class SportsCarBuilder implements CarBuilder {

    private static final int MAX_SEATS = 2;

    private String engine;
    private int seats = MAX_SEATS;
    private boolean hasGps = true;
    private boolean hasSunroof = false;

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        if (seats < 1 || seats > MAX_SEATS) {
            throw new IllegalArgumentException(
                    "Sports car must have between 1 and 2 seats."
            );
        }

        this.seats = seats;
        return this;
    }

    @Override
    public CarBuilder setGps(boolean hasGps) {
        this.hasGps = hasGps;
        return this;
    }

    @Override
    public CarBuilder setSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
        return this;
    }

    @Override
    public Car build() {
        if (engine == null || engine.isBlank()) {
            throw new IllegalStateException(
                    "Engine specification is required for a sports car."
            );
        }

        return new Car(
                CarType.SPORTS_CAR,
                engine,
                seats,
                hasGps,
                hasSunroof
        );
    }
}