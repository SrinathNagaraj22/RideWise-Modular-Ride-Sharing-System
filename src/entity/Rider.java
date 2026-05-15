package entity;

public class Rider {
    int riderId;
    String riderName;
    String riderLocation;

    public Rider(int riderId, String riderName, String riderLocation) {
        this.riderId = riderId;
        this.riderName = riderName;
        this.riderLocation = riderLocation;
    }

    public int getRiderId() {
        return riderId;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getRiderLocation() {
        return riderLocation;
    }

    public void setRiderLocation(String riderLocation) {
        this.riderLocation = riderLocation;
    }
}
