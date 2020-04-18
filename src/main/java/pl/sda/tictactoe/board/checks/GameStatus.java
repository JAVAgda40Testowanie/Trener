package pl.sda.tictactoe.board.checks;

public class GameStatus {
    private boolean isGameFinished;
    private boolean isDraw;
    private char winningMarker;

    public GameStatus(boolean isGameFinished, boolean isDraw, char winningMarker) {
        this.isGameFinished = isGameFinished;
        this.isDraw = isDraw;
        this.winningMarker = winningMarker;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public char getWinningMarker() {
        return winningMarker;
    }
}
