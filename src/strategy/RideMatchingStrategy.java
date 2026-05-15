package strategy;

import entity.Driver;
import entity.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver findDriver(Rider rider, List<Driver> drivers);
}
