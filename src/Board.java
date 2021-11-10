package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    //List of the rows in the current board from top (goal) to bottom (start)
    private ArrayList<Row> rows;
    //Player Unit
    private Player frog;
    //Height of board/number of rows
    final int numRows = 20;
    //Provides starting time in which board is built
    private int startingTime;

    public Board() {
        this.rows = new ArrayList<>();
        this.frog = new Player(12, 20, 0);
        this.startingTime = -1;
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
     * @param time time since board has been built
     * @return true if board shifts, false if it doesn't
     */
    public boolean boardShift(int frogShift, int time) {
        return false;
    }

    /**
     * called every time the board shifts to see if a collision is occurring within the row
     * the frog is currently in
     *
     * @param currentRow current row the frog is in
     * @return if the frog is currently in the same spot as an enemy object
     */
    public boolean checkCollisionRow(int currentRow) {
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

    /**
     *  Resets the frog's position and changes to the next level
     */
    public void completeBoard(){

    }
}
