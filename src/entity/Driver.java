package entity;

import enums.VehicleType;

public class Driver {
    int driverId;
    String driverName;
    String driverCurrentLocation;
    boolean driverAvailability;
    VehicleType vehicleType;
    int totalRides;

    public Driver(int driverId, String driverName, String driverCurrentLocation, boolean driverAvailability, VehicleType vehicleType,int totalRides) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverCurrentLocation = driverCurrentLocation;
        this.driverAvailability = driverAvailability;
        this.vehicleType = vehicleType;
        this.totalRides = totalRides;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverCurrentLocation() {
        return driverCurrentLocation;
    }

    public void setDriverCurrentLocation(String driverCurrentLocation) {
        this.driverCurrentLocation = driverCurrentLocation;
    }

    public boolean getDriverAvailability() {
        return driverAvailability;
    }

    public void setDriverAvailability(boolean driverAvailability) {
        this.driverAvailability = driverAvailability;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }
}
