package com.taxi;

import com.taxi.models.Car;
import com.taxi.models.Driver;
import com.taxi.models.Passenger;
import com.taxi.service.TripService;
import com.taxi.service.TripServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        ApplicationContext applicationContextIOCContainer = new ClassPathXmlApplicationContext("spring-beans.xml");
        TripServiceImpl trip = applicationContextIOCContainer.getBean("trip", TripServiceImpl.class);

        Car car = new Car();
        car.setModel("Toyota");
        car.setType("Lux");

        Driver driver = new Driver();
        driver.setFullName("John Jonny");
        driver.setRating("4.7");

        Passenger passenger = new Passenger();
        passenger.setName("Edwin van der Saar");

        trip.setCar(car);
        trip.setDriver(driver);
        trip.setPassenger(passenger);


        trip.tripDetails();
    }
}
