package pl.sda.tictactoe.board;

public class Field {
    private int position;
    private char content;

    public Field(int position, char content) {
        this.position = position;
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }
}
