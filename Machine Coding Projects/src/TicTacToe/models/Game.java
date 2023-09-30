package TicTacToe.models;

import TicTacToe.exception.DuplicateSymbolException;
import TicTacToe.exception.InvalidBoardSizeException;
import TicTacToe.exception.InvalidBotCountException;
import TicTacToe.exception.InvalidNumberOfPlayersException;
import TicTacToe.service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;

    public Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<Move>();
        this.boardStates = new ArrayList<Board>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = 0;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder dimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder players(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder winningStrategy(WinningStrategy winningStrategy){
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)) botCount++;
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Invalid number of bot count");
            }
        }

        public void validateBoardSize() throws InvalidBoardSizeException {
            if(dimension < 3 || dimension > 10){
                throw new InvalidBoardSizeException("Invalid board size");
            }
        }

        public void validatePlayerNumber() throws InvalidNumberOfPlayersException {
            if(players.size() != dimension - 1){
                throw new InvalidNumberOfPlayersException("Invalid number of players");
            }
        }

        public void validateDuplicateSymbol() throws DuplicateSymbolException {
            HashSet<Character> symbolSet = new HashSet<>();
            for(Player player: players){
                symbolSet.add(player.getSymbol());
            }
            if(symbolSet.size() != players.size()){
                throw new DuplicateSymbolException("All players should have unique symbol");
            }
        }

        public void validate() throws InvalidBotCountException, InvalidBoardSizeException, InvalidNumberOfPlayersException, DuplicateSymbolException {
            validateBotCount();
            validateBoardSize();
            validatePlayerNumber();
            validateDuplicateSymbol();
        }

        public Game build() throws InvalidBotCountException, DuplicateSymbolException, InvalidNumberOfPlayersException, InvalidBoardSizeException {
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }
    }
}
