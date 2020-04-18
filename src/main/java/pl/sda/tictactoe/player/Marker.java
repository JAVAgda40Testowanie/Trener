package pl.sda.tictactoe.player;

public enum Marker {
    O('O'),
    X('X');

    public final char label;

    Marker(char label) {
        this.label = label;
    }
}
