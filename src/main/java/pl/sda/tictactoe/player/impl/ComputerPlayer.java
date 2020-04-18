package pl.sda.tictactoe.player.impl;

import pl.sda.tictactoe.board.Board;
import pl.sda.tictactoe.board.exceptions.NotValidPositionException;
import pl.sda.tictactoe.player.Marker;
import pl.sda.tictactoe.player.Player;

import java.util.Random;

public class ComputerPlayer implements Player {
    private Marker marker;

    public ComputerPlayer(Marker marker) {
        this.marker = marker;
    }

    @Override
    public boolean move(Board board) {
        // Random int from 0 to 8
        int position = new Random().nextInt(9);
        try {
            return board.move(position, marker);
        } catch (NotValidPositionException e) {
            System.out.println(
                    String.format("Not valid field number: %d. Please choose one more time.", position)
            );
            return false;
        }
    }

    @Override
    public char getMarker() {
        return marker.label;
    }
}
