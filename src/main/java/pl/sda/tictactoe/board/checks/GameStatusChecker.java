package pl.sda.tictactoe.board.checks;

import pl.sda.tictactoe.board.Field;

import java.util.List;

import static pl.sda.tictactoe.player.Marker.O;
import static pl.sda.tictactoe.player.Marker.X;

public class GameStatusChecker {

    private static final int FIELDS_IN_ROW = 3;

    /**
     * Checks if game is not over on specified line.
     *
     * @param gameFields Fields available on game.
     * @param check      Line to check.
     * @return Line status.
     */
    public static GameStatus checkGameStatus(List<Field> gameFields, LineCheck check) {
        // Check if someone won
        Field initialField = gameFields.get(check.getInitialFieldIndex());
        int currentCheckPosition = check.getInitialFieldIndex();

        if (initialField.getContent() == O.label || initialField.getContent() == X.label) {
            for (int i = 1; i < FIELDS_IN_ROW; i++) {
                currentCheckPosition += check.getStep();
                Field nextField = gameFields.get(currentCheckPosition);

                if (nextField.getContent() != initialField.getContent()) {
                    return new GameStatus(false, false, '*');
                }
            }

            return new GameStatus(true, false, initialField.getContent());
        }

        return new GameStatus(false, false, '/');
    }

    public static GameStatus checkDraw(List<Field> gameFields) {
        return gameFields.stream()
                .allMatch(field -> field.getContent() == O.label || field.getContent() == X.label) ?
                new GameStatus(true, true, '|') : null;
    }
}
