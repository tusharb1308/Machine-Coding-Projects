package TicTacToe.service.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
