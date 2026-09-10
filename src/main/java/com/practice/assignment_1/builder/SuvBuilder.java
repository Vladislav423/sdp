package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;
import com.practice.assignment_1.model.CarType;

public class SuvBuilder implements CarBuilder {
    private CarType carType = CarType.SUV;
    private String engine;
    private int seats = 5;
    private boolean hasGps = true;
    private boolean hasSunroof = true;

    @Override
    public CarBuilder setCarType(CarType type) {
        this.carType = type;
        return this;
    }

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        if (seats < 4 || seats > 8) {
            throw new IllegalArgumentException("SUV seats must be between 4 and 8.");
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
            throw new IllegalStateException("Validation Error: SUV engine must not be empty.");
        }
        return new Car(carType, engine, seats, hasGps, hasSunroof);
    }
}