package strategy;

import entity.Ride;

public class PeakHourFareStrategy implements FareCalculationStrategy{

    @Override
    public double calculateFare(Ride ride) {
        return ride.getRideDistance() * 20;
    }
}
