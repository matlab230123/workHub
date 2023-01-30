package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class TripImpl implements Trip{

    private UUID tripId;
    private Car car;
    private Driver driver;
    private Passenger passenger;

    public TripImpl(Car car, Driver driver, Passenger passenger) {
        this.tripId = UUID.randomUUID();
        this.car = car;
        this.driver = driver;
        this.passenger = passenger;
    }

    public UUID getTripId() {
        return tripId;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public void tripDetails() throws ParseException {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyy-MM-dd");
        Date start = sdFormat.parse(LocalDateTime.now().minusMinutes(20).toString());
        Date end = sdFormat.parse(LocalDateTime.now().toString());

        System.out.println("Trip details: " +
                "\ntripId: " +tripId +
                "\nDriver: " + driver.getFullName() + ", rating: " + driver.getRating() +
                "\nPassenger: " + passenger.getName() +
                "\nCar: " + car.getModel() + ", model: " + car.getModel() + ", type: " +car.getType() +
                "\nTrip started at: " + start + "\nTrip ended: " + end
        );
    }
}
