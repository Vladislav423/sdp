package com.practice.assignment_1.builder;

import com.practice.assignment_1.model.Car;

public interface CarBuilder {
    CarBuilder setEngine(String engine);

    CarBuilder setSeats(int seats);

    CarBuilder setGps(boolean hasGps);

    CarBuilder setSunroof(boolean hasSunroof);

    Car build();
}