package strategy;

import entity.Ride;

public interface FareCalculationStrategy {
    double calculateFare(Ride ride);
}
