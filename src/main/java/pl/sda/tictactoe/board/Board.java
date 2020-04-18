package pl.sda.tictactoe.board;

import pl.sda.tictactoe.board.checks.GameStatus;
import pl.sda.tictactoe.board.checks.LineCheck;
import pl.sda.tictactoe.board.exceptions.NotValidPositionException;
import pl.sda.tictactoe.player.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static pl.sda.tictactoe.board.checks.GameStatusChecker.checkDraw;
import static pl.sda.tictactoe.board.checks.GameStatusChecker.checkGameStatus;
import static pl.sda.tictactoe.board.checks.LineCheck.getAllChecks;
import static pl.sda.tictactoe.player.Marker.O;
import static pl.sda.tictactoe.player.Marker.X;

public class Board {
    private List<Field> fields;

    private Board() {
        fields = new ArrayList<>();
        IntStream.range(1, 10)
                .forEach(index -> fields.add(
                        new Field(
                                index,
                                Integer.toString(index).charAt(0)
                        ))
                );
    }

    public static Board newBoard() {
        return new Board();
    }

    /**
     * Checks if move is possible and performs it if is valid.
     *
     * @param position Position on the board.
     * @param marker   Player marker to put on the map.
     * @return {@code true} if move was made, {@code false} otherwise.
     */
    public boolean move(int position, Marker marker) throws NotValidPositionException {
        if (position < 0 || position > 8) {
            throw new NotValidPositionException();
        }

        Field fieldToChange = fields.get(position);
        if (fieldToChange.getContent() == O.label || fieldToChange.getContent() == X.label) {
            return false;
        }

        fieldToChange.setContent(marker.label);
        return true;
    }

    public void draw() {
        System.out.println(String.format("\t%s | %s | %s", fields.get(0).getContent(), fields.get(1).getContent(), fields.get(2).getContent()));
        System.out.println("\t_________");
        System.out.println(String.format("\t%s | %s | %s", fields.get(3).getContent(), fields.get(4).getContent(), fields.get(5).getContent()));
        System.out.println("\t_________");
        System.out.println(String.format("\t%s | %s | %s", fields.get(6).getContent(), fields.get(7).getContent(), fields.get(8).getContent()));
    }

    /**
     * Checks if game is finished
     *
     * @return If game is over returns {@code LineStatus} object with winning marker.
     * If no winner yet, draw situation will be checked.
     * When no draw {@code null} is returned.
     */
    public GameStatus isGameFinished() {
        List<LineCheck> allChecks = getAllChecks();

        Optional<GameStatus> firstWinningRow = allChecks.stream()
                .map(lineCheck -> checkGameStatus(fields, lineCheck))
                .filter(GameStatus::isGameFinished)
                .findFirst();

        return firstWinningRow.orElseGet(() -> checkDraw(fields));
    }
}
