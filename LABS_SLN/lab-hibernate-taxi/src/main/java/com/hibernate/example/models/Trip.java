package com.hibernate.example.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tripDetails;
    @OneToMany(mappedBy = "trip")
    private List<Passenger> passengerList;

    public Trip() {
    }

    public Trip(String tripNumber) {
        this.tripDetails = tripNumber;
    }
    public int getId() {
        return id;
    }

    public String getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(String tripDetails) {
        this.tripDetails = tripDetails;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void addPassenger(Passenger thePassenger) {
        if(passengerList==null){
            passengerList=new ArrayList<>();
        }
        passengerList.add(thePassenger);
        thePassenger.addTrip(this);
    }
}
