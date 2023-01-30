package com.demo;

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
        Trip trip = applicationContextIOCContainer.getBean("Trip",TripImpl.class);
        trip.tripDetails();
    }
}
