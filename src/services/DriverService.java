package services;

import entity.Driver;
import exception.DriverNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DriverService {
    private List<Driver> driverList;

    public DriverService() {
        this.driverList = new ArrayList<>();
    }

    public void addNewDriver(Driver driver){
        driverList.add(driver);
    }

    public Driver updateAvailability(int driverID, boolean availability){
        for(int i =0;i<driverList.size();i++){
            if(driverID == driverList.get(i).getDriverId()){
                driverList.get(i).setDriverAvailability(availability);
                return driverList.get(i);
            }
        }
        throw new DriverNotFoundException("Driver is not available");
    }

    public List<Driver> listAvailableDriver(){
        List<Driver> availableDriver = new ArrayList<>();
        for(int i =0;i<driverList.size();i++){
            if(driverList.get(i).getDriverAvailability()){
                availableDriver.add(driverList.get(i));
            }
        }
        return  availableDriver;
    }

}
