package pl.sda.tictactoe.player;

import pl.sda.tictactoe.board.Board;

/**
 * Represents player.
 */
public interface Player {
    /**
     * Move to specified field on board.
     * @param board     Game board.
     * @return {@code true} when move was valid, {@code false} otherwise.
     */
    boolean move(Board board);

    char getMarker();
}
