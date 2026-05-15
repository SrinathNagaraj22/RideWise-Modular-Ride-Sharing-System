import entity.Driver;
import entity.FareReceipt;
import entity.Rider;
import enums.VehicleType;
import services.DriverService;
import services.RideService;
import services.RiderService;
import strategy.DefaultFareStrategy;
import strategy.FareCalculationStrategy;
import strategy.NearestDriverStrategy;
import strategy.RideMatchingStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();
        RideMatchingStrategy rideMatchingStrategy = new NearestDriverStrategy();
        FareCalculationStrategy fareCalculationStrategy = new DefaultFareStrategy();
        RideService rideService = new RideService(riderService, driverService, rideMatchingStrategy, fareCalculationStrategy);
        while (true) {
            System.out.println("\n===== RideWise Menu =====");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. View Rides");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Enter Rider ID: ");
                        int riderId = sc.nextInt();
                        System.out.print("Enter Rider Name: ");
                        String riderName = sc.next();
                        System.out.print("Enter Rider Location: ");
                        String riderLocation = sc.next();
                        Rider rider = new Rider(riderId, riderName, riderLocation);
                        riderService.addNewRider(rider);
                        System.out.println("Rider added successfully!");
                        break;
                    }
                    case 2: {
                        System.out.print("Enter Driver ID: ");
                        int driverId = sc.nextInt();
                        System.out.print("Enter Driver Name: ");
                        String driverName = sc.next();
                        System.out.print("Enter Driver Location: ");
                        String driverLocation = sc.next();
                        Driver driver = new Driver(driverId, driverName, driverLocation, true, VehicleType.BIKE, 0);
                        driverService.addNewDriver(driver);
                        System.out.println("Driver added successfully!");
                        break;
                    }
                    case 3: {
                        System.out.println("\nAvailable Drivers:");
                        for (Driver driver : driverService.listAvailableDriver()) {
                            System.out.println("Driver ID: " + driver.getDriverId() + " | Name: " + driver.getDriverName() + " | Location: " + driver.getDriverCurrentLocation());
                        }
                        break;
                    }
                    case 4: {
                        System.out.print("Enter Ride ID: ");
                        int rideId = sc.nextInt();
                        System.out.print("Enter Rider ID: ");
                        int riderId = sc.nextInt();
                        System.out.print("Enter Distance: ");
                        double distance = sc.nextDouble();
                        FareReceipt fareReceipt = rideService.requestRide(rideId, riderId, distance);
                        if (fareReceipt != null) {
                            System.out.println("Ride booked successfully!");
                            System.out.println("Fare Amount: " + fareReceipt.getRideAmount());
                        } else {
                            System.out.println("Ride booking failed!");
                        }
                        break;
                    }
                    case 5: {
                        System.out.print("Enter Ride ID: ");
                        int rideId = sc.nextInt();
                        rideService.completeRide(rideId);
                        System.out.println("Ride completed successfully!");
                        break;
                    }
                    case 6: {
                        System.out.println("\nAll Rides:");
                        rideService.getAllRides().forEach(ride -> {
                            System.out.println("Ride ID: " + ride.getRideId() + " | Rider: " + ride.getRider().getRiderName() + " | Driver: " + ride.getDriver().getDriverName() + " | Status: " + ride.getRideStatus());
                        });
                        break;
                    }
                    case 7: {
                        System.out.println("Thank You!");
                        sc.close();
                        return;
                    }
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

//creating a PR