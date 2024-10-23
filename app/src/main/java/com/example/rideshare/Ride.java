package com.example.rideshare;

public class Ride {
    private String pickupLocation;
    private String dropOffLocation;
    private String availableSeats;
    private String departureTime;

    public Ride() {
        // Required empty constructor for Firestore
    }

    public Ride(String pickupLocation, String dropOffLocation, String availableSeats, String departureTime) {
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return pickupLocation + " to " + dropOffLocation + ", Seats: " + availableSeats + ", Departure: " + departureTime;
    }
}
