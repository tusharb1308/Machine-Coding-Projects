package TicTacToe.service.botPlayingStrategy;

import TicTacToe.exception.GameOverException;
import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player) throws GameOverException;
}
