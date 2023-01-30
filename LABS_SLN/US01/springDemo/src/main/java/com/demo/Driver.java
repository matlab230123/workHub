package com.demo;

public class Driver {
    private final String fullName;
    private final String rating;

    public Driver(String fullName, String rating) {
        this.fullName = fullName;
        this.rating = rating;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRating() {
        return rating;
    }
}
