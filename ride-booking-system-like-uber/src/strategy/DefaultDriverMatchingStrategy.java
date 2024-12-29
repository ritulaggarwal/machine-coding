package strategy;

import manager.DriverManager;
import model.Driver;
import model.Location;
import model.Rider;
import model.TripDriverMatchMetadata;

import java.util.List;

public class DefaultDriverMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(TripDriverMatchMetadata tripDriverMatchMetadata) {
        var driverManager = DriverManager.getDriverManager();
        var drivers= driverManager.getDriversList();
        if(drivers.isEmpty()) {
            System.out.println("Sorry! No Drivers found.");
            return null;
        }
        return drivers.getFirst();
    }
}
