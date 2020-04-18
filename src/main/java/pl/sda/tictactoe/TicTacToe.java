package pl.sda.tictactoe;

import pl.sda.tictactoe.board.Board;
import pl.sda.tictactoe.board.checks.GameStatus;
import pl.sda.tictactoe.player.Player;

import java.io.IOException;
import java.util.List;

public class TicTacToe {
    private Board board;
    private List<Player> players;

    public TicTacToe(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void start() throws IOException {
        int turnNumber = 0;
        GameStatus gameStatus = null;
        while (gameStatus == null) {
            clearConsoleAndDrawBoard(board);

            Player ongoingPlayer = players.get(turnNumber % 2);
            System.out.println(
                    String.format("Player with marker %s move", ongoingPlayer.getMarker())
            );
            while (!ongoingPlayer.move(board)) {
                System.out.println("Not valid move, please try again");
            }

            turnNumber++;
            gameStatus = board.isGameFinished();
        }

        clearConsoleAndDrawBoard(board);

        System.out.println(
                String.format("Game took %d moves.", turnNumber - 1)
        );

        if (gameStatus.isDraw()) {
            System.out.println("Game finished with a draw");
        } else {
            System.out.println(
                    String.format("Player with marker %s won!", gameStatus.getWinningMarker())
            );
        }
    }

    private void clearConsoleAndDrawBoard(Board board) throws IOException {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        } else {
            Runtime.getRuntime().exec("clear");
        }
        board.draw();
    }
}
