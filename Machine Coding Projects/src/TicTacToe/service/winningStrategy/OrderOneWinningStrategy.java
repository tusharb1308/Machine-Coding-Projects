package TicTacToe.service.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMaps;
    private List<HashMap<Character, Integer>> colHashMaps;
    private HashMap<Character, Integer> topLeftHashMaps;
    private HashMap<Character, Integer> topRightHashMaps;
    private HashMap<Character, Integer> cornerHashMaps;

    public OrderOneWinningStrategy(int dimension){
        this.dimension = dimension;
        rowHashMaps = new ArrayList<>();
        colHashMaps = new ArrayList<>();
        topLeftHashMaps = new HashMap<>();
        topRightHashMaps = new HashMap<>();
        cornerHashMaps = new HashMap<>();
        for(int i=0; i<dimension; i++){
            rowHashMaps.add(new HashMap<>());
            colHashMaps.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        if(checkRowWin(row, symbol)) return player;
        else if(checkColumnWin(col, symbol)) return player;
        else if(isTopLeftDiagonalCell(row, col) && checkTopLeftDiagonalWin(symbol)) return player;
        else if(isTopRightDiagonalCell(row, col) && checkTopRightDiagonalWin(symbol)) return player;
        else if(isCornerCell(row, col) && checkCornerWin(symbol)) return player;

        return null;
    }

    public boolean isTopLeftDiagonalCell(int row, int col){
        return row == col;
    }

    public boolean isTopRightDiagonalCell(int row, int col){
        return (row + col) == (dimension-1);
    }

    private boolean isCornerCell(int row, int col){
        if(row == 0 || row == dimension - 1) return col == 0 || col == dimension - 1;

        return false;
    }

    private boolean checkRowWin(int row, char symbol){
        rowHashMaps.get(row).putIfAbsent(symbol, 0);
        rowHashMaps.get(row).put(
                symbol,
                rowHashMaps.get(row).get(symbol) + 1
        );
        return rowHashMaps.get(row).get(symbol) == dimension;
    }

    private boolean checkColumnWin(int row, char symbol){
        colHashMaps.get(row).putIfAbsent(symbol, 0);
        colHashMaps.get(row).put(
                symbol,
                colHashMaps.get(row).get(symbol) + 1
        );
        return colHashMaps.get(row).get(symbol) == dimension;
    }

    private boolean checkTopRightDiagonalWin(char symbol){
        topRightHashMaps.putIfAbsent(symbol, 0);
        topRightHashMaps.put(
                symbol,
                topRightHashMaps.get(symbol) + 1
        );
        return topRightHashMaps.get(symbol) == dimension;
    }

    private boolean checkTopLeftDiagonalWin(char symbol){
        topLeftHashMaps.putIfAbsent(symbol, 0);
        topLeftHashMaps.put(
                symbol,
                topLeftHashMaps.get(symbol) + 1
        );
        return topLeftHashMaps.get(symbol) == dimension;
    }

    private boolean checkCornerWin(char symbol){
        cornerHashMaps.putIfAbsent(symbol, 0);
        cornerHashMaps.put(
                symbol,
                cornerHashMaps.get(symbol) + 1
        );
        return cornerHashMaps.get(symbol) == 4;
    }
}
