package ParkingLot;

import ParkingLot.controller.TicketController;
import ParkingLot.dto.TicketRequestDTO;
import ParkingLot.dto.TicketResponseDTO;
import ParkingLot.exception.GateNotFoundException;
import ParkingLot.exception.NoEmptyParkingSlotAvailableException;
import ParkingLot.exception.ParkingLotNotFoundException;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.constants.VehicleType;
import ParkingLot.repository.*;
import ParkingLot.service.InitService;
import ParkingLot.service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        ParkingLot parkingLot = parkingLotRepository.get(1);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("BMW");
        ticketRequestDTO.setColor("Blue");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("1234");

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
        
        System.out.println(ticketResponseDTO);
    }
}
