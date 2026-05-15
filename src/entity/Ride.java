package entity;

import enums.RideStatus;

public class Ride {
    int rideId;
    Rider rider;
    Driver driver;
    Double rideDistance;
    RideStatus rideStatus;

    public Ride(int rideId, Rider rider,Driver driver ,Double rideDistance, RideStatus rideStatus) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.rideDistance = rideDistance;
        this.rideStatus = rideStatus;
    }

    public int getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(Double rideDistance) {
        this.rideDistance = rideDistance;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void completeRide(){
        this.rideStatus = RideStatus.COMPLETED;
    }

    public void cancelRide(){
        this.rideStatus = RideStatus.CANCELLED;
    }

    public void assignDriver(Driver driver){
        this.setDriver(driver);
        this.rideStatus = RideStatus.ASSIGNED;
    }
}
