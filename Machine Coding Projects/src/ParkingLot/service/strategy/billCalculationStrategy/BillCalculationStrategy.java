package ParkingLot.service.strategy.billCalculationStrategy;

import ParkingLot.models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    double calculationBillAmount(Ticket ticket, LocalDateTime exitTime);
}