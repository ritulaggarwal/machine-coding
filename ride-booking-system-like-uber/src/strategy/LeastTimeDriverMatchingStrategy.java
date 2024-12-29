package strategy;

import manager.DriverManager;
import model.Driver;
import model.TripDriverMatchMetadata;

public class LeastTimeDriverMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripDriverMatchMetadata tripDriverMatchMetadata) {
        var driverManager = DriverManager.getDriverManager();
        var drivers = driverManager.getDriversList();
        if(drivers.isEmpty()) {
            return null;
        }
        // Use QuadTrees Algo to find driver
        return drivers.getFirst();
    }
}
