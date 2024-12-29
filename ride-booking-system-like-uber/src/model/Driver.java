package model;

import enums.Rating;

public class Driver {

    private String id;
    private String name;
    private Trip currentTrip;
    private boolean isAcceptingRide;
    private Vehicle vehicle;
    private Rating rating;

    public Driver(String id, String name, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.isAcceptingRide = true;
        this.vehicle = vehicle;
        this.rating = Rating.UNASSIGNED;
    }

    public boolean isAvailable() {
        return isAcceptingRide && currentTrip == null;
    }


    public void setAcceptingRide(boolean acceptingRide) {
        isAcceptingRide = acceptingRide;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
