package manager;

import enums.TripStatus;
import model.*;
import strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class TripManager {

    private Map<String, Trip> trips;
    private static TripManager tripManager = null;
    private final RiderManager riderManager;
    private final DriverManager driverManager;

    private TripManager() {
        riderManager = RiderManager.getRiderManager();
        driverManager = DriverManager.getDriverManager();
        trips = new HashMap<>();
    }

    public static TripManager getTripManager() {
        if(tripManager == null) {
            synchronized (TripManager.class) {
                if(tripManager == null) {
                    tripManager = new TripManager();
                }
            }
        }
        return tripManager;
    }


    public String createTrip(Rider rider, Location pickup, Location destination) {
        TripPricingMetadata tripPricingMetadata = new TripPricingMetadata(rider, pickup, destination);
        TripDriverMatchMetadata tripDriverMatchMetadata = new TripDriverMatchMetadata(rider, pickup, destination);
        var strategyManager = StrategyManager.getStrategyManager();
        var pricingStrategy = strategyManager.determinePricingStrategy(tripPricingMetadata);
        var driverMatchingStrategy = strategyManager.determineDrivingMatchingStrategy(tripDriverMatchMetadata);
        var trip = new Trip(rider, pickup, destination, pricingStrategy, driverMatchingStrategy);
        var driver = driverMatchingStrategy.matchDriver(tripDriverMatchMetadata);
        if(driver == null) {
            System.out.println("No driver found at this moment, try again!!");
            trips.put(trip.getTripId(), trip);
            return trip.getTripId();
        }
        trip.setDriver(driver);
        trip.setTripStatus(TripStatus.DRIVER_ON_THE_WAY);
        System.out.println("Driver is on the way");
        trips.put(trip.getTripId(), trip);
        return trip.getTripId();
    }


}
