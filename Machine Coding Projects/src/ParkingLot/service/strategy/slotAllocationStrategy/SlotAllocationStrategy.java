package ParkingLot.service.strategy.slotAllocationStrategy;

import ParkingLot.exception.NoEmptyParkingSlotAvailableException;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoEmptyParkingSlotAvailableException;
}
