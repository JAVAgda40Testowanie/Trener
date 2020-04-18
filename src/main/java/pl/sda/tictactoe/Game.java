package pl.sda.tictactoe;

import pl.sda.tictactoe.board.Board;
import pl.sda.tictactoe.player.Marker;
import pl.sda.tictactoe.player.Player;
import pl.sda.tictactoe.player.impl.ComputerPlayer;
import pl.sda.tictactoe.player.impl.HumanPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args) throws IOException {
        List<Player> players = generatePlayers();
        Board gameBoard = Board.newBoard();

        TicTacToe game = new TicTacToe(gameBoard, players);

        game.start();
    }

    private static List<Player> generatePlayers() {
        List<Player> players = new ArrayList<>();

        // 0 - human starts, 1 - computer
        int coinToss = new Random().nextInt(2);

        if (coinToss == 0) {
            players.add(new HumanPlayer(Marker.O));
            players.add(new ComputerPlayer(Marker.X));
        } else {
            players.add(new ComputerPlayer(Marker.O));
            players.add(new HumanPlayer(Marker.X));
        }

        return players;
    }
}
