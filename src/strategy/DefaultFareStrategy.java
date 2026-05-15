package strategy;

import entity.Ride;

public class DefaultFareStrategy implements FareCalculationStrategy{
    @Override
    public double calculateFare(Ride ride) {
        return ride.getRideDistance() * 10;
    }
}
