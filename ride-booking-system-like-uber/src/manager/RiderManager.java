package manager;

import model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {

    private Map<String, Rider> riders;
    private static RiderManager riderManager =  null;

    private RiderManager() {
        riders = new HashMap<>();
    }

    public static RiderManager getRiderManager() {
        if(riderManager == null) {
            synchronized (RiderManager.class) {
                if(riderManager == null) {
                    riderManager = new RiderManager();
                }
            }
        }
        return riderManager;
    }

    public void addRider(Rider rider) {
        if(riders.containsKey(rider.getId())) {
            System.out.println("Rider already exists");
            return;
        }
        riders.put(rider.getId(), rider);
        System.out.println("Rider Added :" + rider.getId());
    }


}
