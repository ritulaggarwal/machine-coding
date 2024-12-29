package strategy;

import model.Driver;
import model.TripDriverMatchMetadata;

public interface DriverMatchingStrategy {

    Driver matchDriver(TripDriverMatchMetadata tripDriverMatchMetadata);

}
