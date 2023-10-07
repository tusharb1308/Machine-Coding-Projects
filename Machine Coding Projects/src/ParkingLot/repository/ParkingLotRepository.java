package ParkingLot.repository;

import ParkingLot.exception.ParkingLotNotFoundException;
import ParkingLot.models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private final HashMap<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId) throws ParkingLotNotFoundException {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("ParkingLot not found for Id:" + parkingLotId);
        }
        return parkingLot;
    }

    public ParkingLot put(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
