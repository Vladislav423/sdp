package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;
import com.practice.assignment_1.model.CarType;

public class SportsCarBuilder  implements CarBuilder{
    private CarType carType = CarType.SPORTS_CAR;
    private String engine;
    private int seats = 2;
    private boolean hasGps = true;
    private boolean hasSunroof = false;

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
        if (seats > 2) {
            throw new IllegalArgumentException("Sports car cannot have more than 2 seats.");
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
            throw new IllegalStateException("Validation Error: Engine specification is strictly required for sports cars.");
        }
        return new Car(carType, engine, seats, hasGps, hasSunroof);
    }
}
