package TicTacToe.service.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategies winningStrategy, int dimension){
//        switch (winningStrategy){
//            case ORDERONE_WINNINGSTRATEGY -> return new OrderOneWinningStrategy(dimension);
//        }
        return new OrderOneWinningStrategy(dimension);
    }
}
