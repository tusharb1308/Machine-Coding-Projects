package ParkingLot.controller;

import ParkingLot.dto.TicketRequestDTO;
import ParkingLot.dto.TicketResponseDTO;
import ParkingLot.exception.GateNotFoundException;
import ParkingLot.exception.NoEmptyParkingSlotAvailableException;
import ParkingLot.exception.ParkingLotNotFoundException;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;
import ParkingLot.repository.GateRepository;
import ParkingLot.repository.ParkingLotRepository;
import ParkingLot.repository.TicketRepository;
import ParkingLot.service.TicketService;
import ParkingLot.service.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {
    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository){
        this.ticketService = new TicketServiceImpl(parkingLotRepository, gateRepository, ticketRepository);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());

        return ticketResponseDTO;
    }
}
