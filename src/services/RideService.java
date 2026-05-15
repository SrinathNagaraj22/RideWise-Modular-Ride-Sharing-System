package services;

import entity.Driver;
import entity.FareReceipt;
import entity.Ride;
import entity.Rider;
import enums.RideStatus;
import exception.DriverNotFoundException;
import exception.RiderNotFoundException;
import strategy.FareCalculationStrategy;
import strategy.RideMatchingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RideService {
    private List<Ride> rideList;
    private RiderService riderService;
    private DriverService driverService;
    private RideMatchingStrategy rideMatchingStrategy;
    private FareCalculationStrategy fareCalculationStrategy;
    public RideService(RiderService riderService, DriverService driverService, RideMatchingStrategy rideMatchingStrategy, FareCalculationStrategy fareCalculationStrategy) {
        this.rideList = new ArrayList<>();
        this.riderService = riderService;
        this.driverService = driverService;
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    public FareReceipt requestRide(int rideId, int riderId, double distance) {
        Rider rider = riderService.getRiderById(riderId);
        if (rider == null) {
            throw new RiderNotFoundException("Rider Not Found");
        }
        List<Driver> availableDrivers =
                driverService.listAvailableDriver();
        Driver selectedDriver =
                rideMatchingStrategy.findDriver(rider, availableDrivers);
        if (selectedDriver == null) {
            throw new DriverNotFoundException("Driver Not Found");
        }
        Ride ride = new Ride(rideId, rider, null, distance, RideStatus.REQUESTED);
        ride.assignDriver(selectedDriver);
        driverService.updateAvailability(selectedDriver.getDriverId(), false);
        double fare = fareCalculationStrategy.calculateFare(ride);
        FareReceipt fareReceipt = new FareReceipt(ride.getRideId(), fare, LocalDateTime.now());
        rideList.add(ride);
        return fareReceipt;
    }
    public void completeRide(int rideId) {
        for (Ride ride : rideList) {
            if (ride.getRideId() == rideId) {
                ride.completeRide();
                driverService.updateAvailability(ride.getDriver().getDriverId(), true);
                break;
            }
        }
    }

    public List<Ride> getAllRides() {
        return rideList;
    }
}