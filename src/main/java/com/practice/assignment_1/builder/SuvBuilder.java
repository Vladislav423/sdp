package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;
import com.practice.assignment_1.model.CarType;

public class SuvBuilder implements CarBuilder {

    private static final int MIN_SEATS = 4;
    private static final int MAX_SEATS = 8;

    private String engine;
    private int seats = 5;
    private boolean hasGps = true;
    private boolean hasSunroof = true;

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        if (seats < MIN_SEATS || seats > MAX_SEATS) {
            throw new IllegalArgumentException(
                    "SUV must have between 4 and 8 seats."
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
                    "Engine specification is required for an SUV."
            );
        }

        return new Car(
                CarType.SUV,
                engine,
                seats,
                hasGps,
                hasSunroof
        );
    }
}