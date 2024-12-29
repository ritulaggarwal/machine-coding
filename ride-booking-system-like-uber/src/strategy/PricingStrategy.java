package strategy;

import model.Location;
import model.Rider;
import model.TripPricingMetadata;

public interface PricingStrategy {

    double calculateTripCost(TripPricingMetadata tripPricingMetadata);

}
