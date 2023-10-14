package ParkingLot.models;

import ParkingLot.models.constants.ParkingSlotStatus;
import ParkingLot.models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int number;
    private VehicleType supportedVehicleTypes;
    private ParkingSlotStatus parkingSlotStatus;
    private Vehicle vehicle;

    public ParkingSlot(){}

    public ParkingSlot(int id, int number, VehicleType supportedVehicleTypes) {
        super(id);
        this.number = number;
        this.supportedVehicleTypes = supportedVehicleTypes;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(VehicleType supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
