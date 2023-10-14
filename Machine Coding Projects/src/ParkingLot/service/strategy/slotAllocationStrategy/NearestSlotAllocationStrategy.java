package ParkingLot.service.strategy.slotAllocationStrategy;

import ParkingLot.exception.NoEmptyParkingSlotAvailableException;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.constants.ParkingSlotStatus;
import ParkingLot.models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoEmptyParkingSlotAvailableException {
        int floorNumber = entryGate.getFloorNumber();
        for(ParkingSlot slot: parkingLot.getParkingFloors().get(floorNumber).getParkingSlot()){
            if(slot.getSupportedVehicleTypes().equals(vehicleType) &&
            slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                return slot;
            }
        }
        int i = floorNumber - 1;
        int j = floorNumber + 1;
        while (i >= 0 || j < parkingLot.getParkingFloors().size()){
            if(i >= 0){
                for(ParkingSlot slot: parkingLot.getParkingFloors().get(i).getParkingSlot()){
                    if(slot.getSupportedVehicleTypes().equals(vehicleType) &&
                            slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                        return slot;
                    }
                }
            }
            if(j < parkingLot.getParkingFloors().size()){
                for(ParkingSlot slot: parkingLot.getParkingFloors().get(j).getParkingSlot()){
                    if(slot.getSupportedVehicleTypes().equals(vehicleType) &&
                            slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                        return slot;
                    }
                }
            }
            i--; j++;
        }
        throw new NoEmptyParkingSlotAvailableException("No Available parking slot as of now, please try again later.");
    }
}
