package strategy;

import entity.Driver;
import entity.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Driver selectedDriver = null;
        for (Driver driver : drivers) {
            if (driver.getDriverAvailability()) {
                if (selectedDriver == null ||
                        driver.getTotalRides() < selectedDriver.getTotalRides()) {
                    selectedDriver = driver;
                }
            }
        }
        return selectedDriver;
    }
}
