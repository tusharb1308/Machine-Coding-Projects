package TicTacToe.exception;

public class DuplicateSymbolException extends Exception{
    public DuplicateSymbolException(){}

    public DuplicateSymbolException(String message){
        super(message);
    }
}
