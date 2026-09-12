# Assignment 1: Builder Pattern

## Project Structure

```text
sdp/
├── src/main/java/com/practice/assignment_1/
│   ├── builder/
│   │   ├── CarBuilder.java
│   │   ├── SportsCarBuilder.java
│   │   └── SuvBuilder.java
│   ├── director/
│   │   └── CarDirector.java
│   ├── model/
│   │   ├── Car.java
│   │   └── CarType.java
│   └── Main.java
├── pom.xml
└── README.md
```

## Car

`Car` is an immutable class representing a configurable vehicle.

It contains:

* `carType` — type of the car (`SPORTS_CAR` or `SUV`)
* `engine` — required engine specification
* `seats` — number of seats
* `hasGps` — whether GPS is installed
* `hasSunroof` — whether the car has a sunroof

The builders validate the car configuration during the building process.

## Sports Car

A sports car can have between 1 and 2 seats and requires an engine.

### Using Director

```java
CarDirector director = new CarDirector();

Car sportsCar = director.constructTrackReadySportsCar(
        new SportsCarBuilder()
);
```

### Custom Build

```java
Car customSportsCar = new SportsCarBuilder()
        .setEngine("Electric Dual-Motor")
        .setSeats(2)
        .setGps(true)
        .setSunroof(false)
        .build();
```

## SUV

An SUV must have between 4 and 8 seats and requires an engine.

### Using Director

```java
CarDirector director = new CarDirector();

Car familySuv = director.constructFamilySuv(
        new SuvBuilder()
);
```

### Custom Build

```java
Car customSuv = new SuvBuilder()
        .setEngine("3.0L Turbo Diesel")
        .setSeats(7)
        .setGps(true)
        .setSunroof(true)
        .build();
```

## How to Run

Requirements:

* JDK 17
* IntelliJ IDEA or Maven

To run the project in IntelliJ IDEA:

1. Open the project.
2. Open `Main.java`.
3. Run `Main.main()`.
4. The console will show Director-built cars, a custom build, and a validation failure example.
