package com.hibernate.example.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void addTrip(Trip trip) {
        this.trip = trip;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket theTicket) {
        if(tickets==null){
            this.tickets=new ArrayList<>();
        }
        this.tickets.add(theTicket);
        theTicket.addPassenger(this);
    }
}
