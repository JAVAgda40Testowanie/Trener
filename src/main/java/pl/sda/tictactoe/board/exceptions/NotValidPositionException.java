package pl.sda.tictactoe.board.exceptions;

public class NotValidPositionException extends Exception {
    public NotValidPositionException() {
        super("Not valid position.");
    }
}
