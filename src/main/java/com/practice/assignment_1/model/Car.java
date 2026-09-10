package com.practice.assignment_1.model;

public class Car {
    private final CarType carType;
    private final String engine;
    private final int seats;
    private final boolean hasGps;
    private final boolean hasSunroof;

    public Car(CarType carType, String engine, int seats, boolean hasGps, boolean hasSunroof) {
        this.carType = carType;
        this.engine = engine;
        this.seats = seats;
        this.hasGps = hasGps;
        this.hasSunroof = hasSunroof;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public boolean hasGps() {
        return hasGps;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    @Override
    public String toString() {
        return "Car [" +
                "Type=" + carType +
                ", Engine='" + engine + '\'' +
                ", Seats=" + seats +
                ", GPS=" + hasGps +
                ", Sunroof=" + hasSunroof +
                ']';
    }
}
