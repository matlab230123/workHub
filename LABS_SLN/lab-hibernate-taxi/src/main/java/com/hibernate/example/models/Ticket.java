package com.hibernate.example.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int ticketNumber;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger = new Passenger();

    public Ticket() {
    }

    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getId() {
        return id;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
