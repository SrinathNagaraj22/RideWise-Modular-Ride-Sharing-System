package services;

import entity.Rider;
import exception.RiderNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    private List<Rider> riderList;

    public RiderService() {
        this.riderList = new ArrayList<>();
    }

    public void addNewRider(Rider rider){
        riderList.add(rider);
    }
    public Rider getRiderById(int id){
        for(int i =0;i< riderList.size();i++){
            if(id == riderList.get(i).getRiderId())
            {
                return riderList.get(i);
            }
        }
        throw new RiderNotFoundException("Rider Not Found");
    }
}
