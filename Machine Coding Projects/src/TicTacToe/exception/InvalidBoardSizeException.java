package TicTacToe.exception;

public class InvalidBoardSizeException extends Exception{
    public InvalidBoardSizeException() {
    }

    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
