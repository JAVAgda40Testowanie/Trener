package pl.sda.tictactoe.board.checks;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Class contains line check parameters which are used to specify whether game has been finished.
 */
public class LineCheck {
    // GAME STATUS CHECKS
    // First field
    private static final LineCheck FROM_FIRST_FIELD_DOWN = new LineCheck(0, 3);
    private static final LineCheck FROM_FIRST_FIELD_DIAGONALLY = new LineCheck(0, 4);
    private static final LineCheck FROM_FIRST_FIELD_RIGHT = new LineCheck(0, 1);

    // Second field
    private static final LineCheck FROM_SECOND_FIELD_DOWN = new LineCheck(1, 3);

    // Third field
    private static final LineCheck FROM_THIRD_FIELD_DOWN = new LineCheck(2, 3);
    private static final LineCheck FROM_THIRD_FIELD_DIAGONALLY = new LineCheck(2, 2);

    // Fourth field
    private static final LineCheck FROM_FOURTH_FIELD_RIGHT = new LineCheck(3, 1);

    // Seventh field
    private static final LineCheck FROM_SEVENTH_FIELD_RIGHT = new LineCheck(6, 1);

    private int initialFieldIndex;
    private int step;

    private LineCheck(int initialFieldIndex, int step) {
        this.initialFieldIndex = initialFieldIndex;
        this.step = step;
    }

    public static List<LineCheck> getAllChecks() {
        return ImmutableList.of(
                FROM_FIRST_FIELD_DOWN,
                FROM_FIRST_FIELD_DIAGONALLY,
                FROM_FIRST_FIELD_RIGHT,
                FROM_SECOND_FIELD_DOWN,
                FROM_THIRD_FIELD_DOWN,
                FROM_THIRD_FIELD_DIAGONALLY,
                FROM_FOURTH_FIELD_RIGHT,
                FROM_SEVENTH_FIELD_RIGHT
        );
    }

    public int getInitialFieldIndex() {
        return initialFieldIndex;
    }

    public int getStep() {
        return step;
    }
}
