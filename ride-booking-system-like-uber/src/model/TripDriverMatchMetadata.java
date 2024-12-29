package model;

public class TripDriverMatchMetadata {

    private Rider rider;
    private Location pickup;
    private Location destination;

    public TripDriverMatchMetadata(Rider rider, Location pickup, Location destination) {
        this.rider = rider;
        this.pickup = pickup;
        this.destination = destination;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
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
}
