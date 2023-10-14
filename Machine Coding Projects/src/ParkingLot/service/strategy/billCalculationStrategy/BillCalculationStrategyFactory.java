package ParkingLot.service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(){
        return new LowBillCalculationStrategy();
    }
}
