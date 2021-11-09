package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {

    private LinkedList<Row> rows;
    private Player frog;
    final int numRows = 20;

    public Board() {
        this.rows = new LinkedList<>();
        this.frog = new Player(12, 20);
    }

    /**
     * calls buildRow for the number of rows in the board
     */
    public void buildBoard() {

    }

    /**
     * Called every frame, checks each row using rowShift to see if they should shift, and checks
     * to see if the player should shift. Then shifts board.
     *
     * @param frogShift determines which direction the frog should move
     * @return true if board shifts, false if it doesn't
     */
    public boolean boardShift(int frogShift) {
        return false;
    }

    /**
     * called every time the board shifts to see if a collision is occurring within the row
     * the frog is currently in
     *
     * @param currentRow current row the frog is in
     * @return if the frog is currently in the same spot as an enemy object
     */
    public boolean checkCollision(int currentRow) {
        return false;
    }

    /**
     * Draws the board inside the console each time it shifts
     */
    public void drawBoard() {

    }

    /**
     * Clears the board each time it shifts
     */
    public void clearBoard() {

    }
}
