package model;

import enums.VehicleType;

public class Vehicle {

    private String vehicleId;
    private String driverId;
    private boolean isOwner;
    private VehicleType vehicleType;

    public Vehicle(String vehicleId, String driverId, boolean isOwner, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.isOwner = isOwner;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
