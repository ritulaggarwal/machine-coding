package manager;

import model.TripDriverMatchMetadata;
import model.TripPricingMetadata;
import strategy.DefaultDriverMatchingStrategy;
import strategy.DefaultPricingStrategy;
import strategy.DriverMatchingStrategy;
import strategy.PricingStrategy;

public class StrategyManager {

    private static StrategyManager strategyManager = null;

    private StrategyManager() {

    }

    public static StrategyManager getStrategyManager() {
        if(strategyManager == null) {
            synchronized (StrategyManager.class) {
                if(strategyManager == null) {
                    strategyManager = new StrategyManager();
                }
            }
        }
        return strategyManager;
    }

    public PricingStrategy determinePricingStrategy(TripPricingMetadata tripPricingMetadata) {
        // Determine appropriate strategy using trip pricing meta data
        return new DefaultPricingStrategy();
    }

    public DriverMatchingStrategy determineDrivingMatchingStrategy(TripDriverMatchMetadata tripDriverMatchMetadata) {
        // Determine appropriate strategy using trip driver match metadata
        return new DefaultDriverMatchingStrategy();
    }

}
