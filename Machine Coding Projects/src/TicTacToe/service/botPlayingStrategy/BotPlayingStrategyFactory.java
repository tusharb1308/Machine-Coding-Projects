package TicTacToe.service.botPlayingStrategy;

public class BotPlayingStrategyFactory {
    // TODO: create a enum for botPlayingStrategy, use it with switch case here
    public static BotPlayingStrategy getBotPlayingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
