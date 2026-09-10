package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;
import com.practice.assignment_1.model.CarType;

public interface CarBuilder {
    CarBuilder setCarType(CarType type);
    CarBuilder setEngine(String engine);
    CarBuilder setSeats(int seats);
    CarBuilder setGps(boolean hasGps);
    CarBuilder setSunroof(boolean hasSunroof);
    Car build();
}
