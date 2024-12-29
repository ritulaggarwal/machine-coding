package model;

import enums.TripStatus;
import strategy.DriverMatchingStrategy;
import strategy.PricingStrategy;
import utils.IdGenerator;

public class Trip {

    private String tripId;
    private Rider rider;
    private Driver driver;
    private Location pickup;
    private Location destination;
    private TripStatus tripStatus;
    // Keeping reference of strategies as it can vary per trip.
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider rider, Location pickup, Location destination, PricingStrategy pricingStrategy,
                DriverMatchingStrategy driverMatchingStrategy) {
        this.rider = rider;
        this.pickup = pickup;
        this.destination = destination;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.tripStatus = TripStatus.DRIVER_NOT_ASSIGNED;
        this.tripId = IdGenerator.getNextId();
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public DriverMatchingStrategy getDriverMatchingStrategy() {
        return driverMatchingStrategy;
    }

    public void setDriverMatchingStrategy(DriverMatchingStrategy driverMatchingStrategy) {
        this.driverMatchingStrategy = driverMatchingStrategy;
    }
}
