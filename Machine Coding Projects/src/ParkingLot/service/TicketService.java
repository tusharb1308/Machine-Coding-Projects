package ParkingLot.service;

import ParkingLot.exception.GateNotFoundException;
import ParkingLot.exception.NoEmptyParkingSlotAvailableException;
import ParkingLot.exception.ParkingLotNotFoundException;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException, NoEmptyParkingSlotAvailableException;
}
