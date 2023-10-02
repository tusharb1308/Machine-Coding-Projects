package TicTacToe.service.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategies winningStrategy, int dimension){
        // TODO: add a switch case basis of the strategy chosen, and return an object
        //        switch (winningStrategy){
//            case ORDERONE_WINNINGSTRATEGY -> return new OrderOneWinningStrategy(dimension);
//        }
        return new OrderOneWinningStrategy(dimension);
    }
}
