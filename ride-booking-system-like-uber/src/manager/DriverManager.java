package manager;

import model.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {

    private Map<String,Driver> drivers;
    private static DriverManager driverManager = null;

    private DriverManager() {
        drivers = new HashMap<>();
    }

    public static DriverManager getDriverManager() {
        if(driverManager == null) {
            synchronized (DriverManager.class) {
                if(driverManager == null) {
                    driverManager = new DriverManager();
                }
            }
        }
        return driverManager;
    }

    public void addDriver(Driver driver) {
        if(drivers.containsKey(driver.getId())) {
            System.out.println("Driver Already Exists: " + driver.getId());
            return;
        }
        this.drivers.put(driver.getId(), driver);
        System.out.println("Driver Added :" + driver.getId());
    }

    public List<Driver> getDriversList() {
        return (List<Driver>) drivers.values();
    }

}
