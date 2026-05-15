package strategy;

import entity.Driver;
import entity.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.getDriverAvailability()) {
                return driver;
            }
        }
        return null;
    }
}
