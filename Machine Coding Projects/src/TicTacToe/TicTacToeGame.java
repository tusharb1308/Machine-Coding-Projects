package TicTacToe;

import TicTacToe.controller.GameController;
import TicTacToe.exception.GameOverException;
import TicTacToe.models.*;
import TicTacToe.service.winningStrategy.WinningStrategies;

import java.util.*;

public class TicTacToeGame {
    public static void main(String[] args) throws GameOverException {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Enter the dimension of the game");
        int dimension = sc.nextInt();

        System.out.println("Will there be any bot in the game ? Y/N");
        String isBotPresent = sc.next();

        List<Player> players = new ArrayList<>();
        int iteratorNumber = dimension - 1;

        if(isBotPresent.equalsIgnoreCase("Y")){
            iteratorNumber = iteratorNumber - 1;
        }

        for(int i=1; i<=iteratorNumber; i++){
            System.out.println("what is the name of player, number: " + i);
            String playerName = sc.next();

            System.out.println("what is the symbol of player, number: " + i);
            String symbol = sc.next();

            players.add(new Player(i, playerName, symbol.charAt(0), PlayerType.HUMAN));
        }

        if(isBotPresent.equalsIgnoreCase("Y")){
            System.out.println("what is the name of the BOT");
            String botName = sc.next();

            System.out.println("what is the symbol of the BOT");
            String botSymbol = sc.next();

            // TODO: take input for bot difficulty level and set strategy accordingly
            BotDifficultyLevel botDifficultyLevel = BotDifficultyLevel.EASY;

            Bot bot = new Bot(dimension, botName, botSymbol.charAt(0), PlayerType.BOT, botDifficultyLevel);
            players.add(bot);
        }

        Collections.shuffle(players);

        Game game = gameController.createGame(dimension, players, WinningStrategies.ORDERONE_WINNINGSTRATEGY);
        int playerIndex = -1;
        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("current board status");
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            Move movePlayed = gameController.executeMove(game, players.get(playerIndex));
//            System.out.println("Do you want to undo your move? Y/N");
//            String isUndoRequired = sc.next();
//            if(isUndoRequired.equalsIgnoreCase("Y")){
//                gameController.undoMove(game, movePlayed);
//            }
            Player winner = gameController.checkWinner(game, movePlayed);
            if(winner != null){
                System.out.println("WINNER IS : " + winner.getName());
                break;
            }
        }

        System.out.println("Final board status");
        gameController.displayBoard(game);
        System.out.println("Do you want a replay");
        // TODO: call the replay logic here
    }
}
