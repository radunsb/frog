package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    //List of the rows in the current board from top (goal) to bottom (start)
    private ArrayList<Row> rows;
    //Player Unit
    private Player frog;
    //Height of board/number of rows
    final int numRows = 10;
    //Provides starting time in which board is built
    private int startingTime;
    // Informs rows when to shift. Increased every time boardShift/nextBoard is called
    private int numFrames;

    public Board() {
        this.rows = new ArrayList<>();
        this.frog = new Player(0, 20, 0);
        this.startingTime = -1;
        numFrames = 0;
    }

    /**
     * constructs Rows for the number of rows in the board
     */
    public void buildBoard() {
        // Rowspeed hard coded to 1
        // Enemies hard coded to the number row
        for (int i = 0; i < numRows; i++) {
            rows.add(new Row(1,i));
        }
    }

    /**
     * Called every frame, checks each row using rowShift to see if they should shift, and checks
     * to see if the player should shift. Then shifts board.
     *
     * @param frogShift determines which direction the frog should move
     * @return true if any part of board shifts, false if it doesn't
     */
    public boolean boardShift(int frogShift) throws Exception {
        numFrames++;
        // TODO: Move frog to new row. This can happen purely on Board.java class level
        // TODO: Calculate shifting rows. This stage could handle collision
        for (Row r : rows) {
            r.rowShift(numFrames);
        }
        // Alternatively check for collision using x coordinates of row (I would prefer not to do this)
        // -Christian
        return false;
    }
    // PROPOSED NAME CHANGE: change boardShift to nextBoard

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
        StringBuilder sb = new StringBuilder();
        for (int i = numRows - 1; i >= 0; i--) {
            sb.append(rows.get(i).toString() + "\n");
        }
        System.out.print(sb.toString());
    }

    /**
     * Clears the board each time it shifts
     */
    public void clearBoard() {
        // TODO: figure out if clearing console in IntelliJ is possible.
        // If not find a terminal emulator that supports it.
        // -Christian
    }

    /**
     *  Resets the frog's position and changes to the next level
     */
    public void completeBoard(){

    }

    // Methods for testing purposes
    public void setFrog(int x, int y) {

    }
}
