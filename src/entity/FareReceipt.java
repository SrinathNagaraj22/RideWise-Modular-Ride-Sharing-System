package entity;

import java.time.LocalDateTime;

public class FareReceipt{
    int rideID;
    Double rideAmount;
    LocalDateTime generatedAt;

    public FareReceipt(int rideID, Double rideAmount, LocalDateTime generatedAt) {
        this.rideID = rideID;
        this.rideAmount = rideAmount;
        this.generatedAt = generatedAt;
    }

    public int getRideID() {
        return rideID;
    }

    public Double getRideAmount() {
        return rideAmount;
    }

    public void setRideAmount(Double rideAmount) {
        this.rideAmount = rideAmount;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
