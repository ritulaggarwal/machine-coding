package strategy;

import model.Location;
import model.TripPricingMetadata;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculateTripCost(TripPricingMetadata tripPricingMetadata) {
        var distance = this.getDistance(tripPricingMetadata.getPickup(), tripPricingMetadata.getDestination());
        return 10 * distance;
    }

    private double getDistance(Location pickup, Location destination) {
        // Use great circle distance/orthodromic distance to find Distance
        // ref: https://www.geeksforgeeks.org/program-distance-two-points-earth/
        return 10;
    }
}
