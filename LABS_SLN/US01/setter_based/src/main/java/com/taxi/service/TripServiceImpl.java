package com.taxi.service;

import com.taxi.models.Car;
import com.taxi.models.Driver;
import com.taxi.models.Passenger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class TripServiceImpl implements TripService{

    private UUID tripId;
    private Car car;
    private Driver driver;
    private Passenger passenger;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void tripDetails() throws ParseException {
        this.tripId = UUID.randomUUID();
        DateTimeFormatter sdFormat = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String start = sdFormat.format(LocalDateTime.now().minusMinutes(20));
        String end = sdFormat.format(LocalDateTime.now());

        System.out.println("Trip details: " +
                "\ntripId: " +tripId +
                "\nDriver: " + driver.getFullName() + ", rating: " + driver.getRating() +
                "\nPassenger: " + passenger.getName() +
                "\nCar: " + car.getModel() + ", model: " + car.getModel() + ", type: " +car.getType() +
                "\nTrip started at: " + start + "\nTrip ended: " + end);
    }
}
