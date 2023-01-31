package com.hibernate.example;

import com.hibernate.example.models.Passenger;
import com.hibernate.example.models.Ticket;
import com.hibernate.example.models.Trip;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "TRIP STARTED" );
        SessionFactory sessionFactory;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = null;
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Ticket ticket1 = new Ticket(5);
        Ticket ticket2 = new Ticket(6);
        Ticket ticket3 = new Ticket(7);
        entityManager.persist(ticket1);
        entityManager.persist(ticket2);
        entityManager.persist(ticket3);

        Passenger passenger1 = new Passenger("Jonny Depp");
        passenger1.addTicket(ticket1);
        passenger1.addTicket(ticket2);
        entityManager.persist(passenger1);

        Passenger passenger2 = new Passenger("James Cameron");
        passenger2.addTicket(ticket1);
        passenger2.addTicket(ticket3);
        entityManager.persist(passenger2);

        Trip trip1 = new Trip("Syd-Mel");
        trip1.addPassenger(passenger1);
        trip1.addPassenger(passenger2);
        entityManager.persist(trip1);

        entityTransaction.commit();
        entityManagerFactory.close();
    }
}
