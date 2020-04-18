package pl.sda.tictactoe.player.impl;

import pl.sda.tictactoe.board.Board;
import pl.sda.tictactoe.board.exceptions.NotValidPositionException;
import pl.sda.tictactoe.player.Marker;
import pl.sda.tictactoe.player.Player;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Marker marker;

    public HumanPlayer(Marker marker) {
        this.marker = marker;
        System.out.println("You are player with marker " + marker.label);
    }

    @Override
    public boolean move(Board board) {
        Scanner scanner = new Scanner(System.in);
        int position = -1;
        System.out.println("Please choose field on the board you want to check");
        try {
            position = scanner.nextInt() - 1;

            return board.move(position, marker);
        } catch (NotValidPositionException e) {
            System.out.println(
                    String.format("Not valid field number: %d. Please choose one more time.", position)
            );
        } catch (Exception e) {
            System.out.println("This is not a number, please enter value again.");
        }

        return false;
    }

    @Override
    public char getMarker() {
        return marker.label;
    }
}
