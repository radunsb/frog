package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    //List of the rows in the current board from top (goal) to bottom (start)
    private ArrayList<Row> rows;
    //Height of board/number of rows
    final int numRows = 10;
    // Informs rows when to shift. Increased every time boardShift/nextBoard is called
    private int numFrames;
    // Width of each row
    private final int rowSize = 48;
    // Stores which row the frog is in (updated when frog is moved)
    private int frogCurrentRow;
    // Stores the x coordinate of the frog (updated when frog is moved)
    private int frogXIndex;

    public Board(boolean randomizeRowSpeed) {
        this.rows = new ArrayList<>();
        numFrames = 0;
        frogXIndex = 24;
        frogCurrentRow = 0;
        if (randomizeRowSpeed) {
            buildBoard(true);
        }
    }

    public Board(int frogInitX, int frogInitY) {
        this.rows = new ArrayList<>();
        numFrames = 0;
        frogXIndex = frogInitX;
        frogCurrentRow = frogInitY;
    }

    public Board() {
        this.rows = new ArrayList<>();
        numFrames = 0;
        frogXIndex = 24;
        frogCurrentRow = 0;
    }

    public Board(double emptyRowCoef, int rowSpeedCoef, int numEnemiesCoef) {
        this.rows = new ArrayList<>();
        numFrames = 0;
        frogXIndex = 24;
        frogCurrentRow = 0;
        buildBoard(emptyRowCoef, rowSpeedCoef, numEnemiesCoef);
    }

    /**
     * constructs Rows for the number of rows in the board
     */
    public void buildBoard() {
        // Rowspeed hard coded to 1
        // Enemies hard coded to the number of the row
        for (int i = 0; i < numRows; i++) {
            rows.add(new Row(1, i, rowSize));
        }
        // Checks to make sure there is not an enemy in the spot to spawn the frog
        while ((rows.get(frogCurrentRow).hasEnemy(frogXIndex))) {
            System.out.println("This loop be running");
            try {
                rows.get(frogCurrentRow).rowShift(numFrames);
            } catch (Exception e) {
                System.out.println("It is literally impossible for this error to be thrown. " +
                        "If this happens I will be very surprised");
            }
        }
        // Spawn frog
        setFrog();
    }

    public void buildBoard(boolean randomizeRowSpeed) {
        // Rowspeed hard coded to 1
        // Enemies hard coded to the number of the row
        for (int i = 0; i < numRows; i++) {
            rows.add(new Row(((int)(Math.random()*4)+1), i, rowSize));
        }
        // Checks to make sure there is not an enemy in the spot to spawn the frog
        while ((rows.get(frogCurrentRow).hasEnemy(frogXIndex))) {
            System.out.println("This loop be running");
            try {
                rows.get(frogCurrentRow).rowShift(numFrames);
            } catch (Exception e) {
                System.out.println("It is literally impossible for this error to be thrown. " +
                        "If this happens I will be very surprised");
            }
        }
        // Spawn frog
        setFrog();
    }

    /**
     *
     * @param emptyRowCoef [range: 0.0 - 1.0] is the probability that a given row will be initialized empty
     *                     (like a patch of grass in frogger)
     * @param rowSpeedCoef [range: 1 - 10] corresponds with the average speed of the rows (lower numbers are slower)
     * @param numEnemiesCoef [range: 1 - 10] corresponds with the average number of enemies in the row (lower is less enemies)
     */
    public void buildBoard(double emptyRowCoef, int rowSpeedCoef, int numEnemiesCoef) {
        int rowSpeedRange = (int) (Math.sqrt( (double) (20 / rowSpeedCoef))) + 1;
        int sNumEnemies = (numEnemiesCoef / 3) + 4;
        int gNumEnemies = (numEnemiesCoef * 3) - 4;
        for (int i = 0; i < numRows; i++) {
            if (Math.random() < emptyRowCoef) {
                rows.add(new Row(1, 0, rowSize));
            } else {
                int rowSpeed = (int) (Math.random()*rowSpeedRange) + 1;
                int numEnemies = (int) ((Math.random()*(gNumEnemies-sNumEnemies))+sNumEnemies) * (i == 0 ? 0 : 1); // Guarantees no enemies spawn in row 0
                rows.add(new Row(rowSpeed, numEnemies, rowSize));
            }
        }
        // Checks to make sure there is not an enemy in the spot to spawn the frog
        while ((rows.get(frogCurrentRow).hasEnemy(frogXIndex))) {
            System.out.println("This loop be running");
            try {
                rows.get(frogCurrentRow).rowShift(numFrames);
            } catch (Exception e) {
                System.out.println("It is literally impossible for this error to be thrown. " +
                        "If this happens I will be very surprised");
            }
        }
        // Spawn frog
        setFrog();
    }

    /**
     * Called every frame, checks each row using rowShift to see if they should shift, and checks
     * to see if the player should shift. Then shifts board.
     *
     * @param frogShift determines which direction the frog should move
     *                  0 = none
     *                  1 = up
     *                  2 = down
     *                  3 = left
     *                  4 = right
     * @return true if any part of board shifts, false if it doesn't
     */
    public boolean boardShift(int frogShift) throws Exception {
        numFrames++;
        // If there is a move code
        if (frogShift > 0 && frogShift < 5) {
            moveFrog(frogShift);
        }

        for (Row r : rows) {
            r.rowShift(numFrames);
        }
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
        System.out.print(sb);
    }

    public String drawBoardString(){
        StringBuilder sb = new StringBuilder();
        for (int i = numRows - 1; i >= 0; i--) {
            sb.append(rows.get(i).toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Clears the board each time it shifts
     */
    public void clearBoard() {
        // In terminal emulator Alacritty this code works.
        System.out.println("\003[H\003[2J");
    }

    /**
     *  Resets the frog's position and changes to the next level
     */
    public void completeBoard() {

    }

    public int getNumFrames() {
        return numFrames;
    }

    // Methods for testing purposes
    public void setFrog() {
        rows.get(frogCurrentRow).frogAppears(frogXIndex);
    }

    public void setFrog(int row){
        rows.get(row).frogAppears(frogXIndex);
    }

    public void moveFrog(int moveCode) throws Exception, ArrayIndexOutOfBoundsException {

        if (moveCode < 0 || moveCode > 4) {
            throw new IllegalArgumentException("Move codes should be within 0 and 4");
        }

        if (moveCode == 1) {
            // Makes sure that the frog does not move up if it is in the top row.
            // If the frog is in the top row and the move code is received, it will call completeBoard()
            if (frogCurrentRow < numRows) {
                if (rows.get(frogCurrentRow + 1).hasEnemy(frogXIndex)) {
                    throw new Exception("Enemy collision detected.");
                } else {
                    rows.get(frogCurrentRow).frogLeaves(frogXIndex);
                    rows.get(frogCurrentRow + 1).frogAppears(frogXIndex);
                }
                frogCurrentRow++;
            } else {
                completeBoard();
            }

        } else if (moveCode == 2) {
            //Makes sure that the frog does not move down if it is on the bottom row
            if(frogCurrentRow != 0) {
                if (rows.get(frogCurrentRow - 1).hasEnemy(frogXIndex)) {
                    throw new Exception("Enemy collision detected.");
                } else {
                    rows.get(frogCurrentRow).frogLeaves(frogXIndex);
                    rows.get(frogCurrentRow - 1).frogAppears(frogXIndex);
                }
                frogCurrentRow--;
            }

        } else {
            rows.get(frogCurrentRow).moveFrogLeftRight(moveCode, frogXIndex);
            if (moveCode == 3 && frogXIndex != 0)
                frogXIndex--;
            if (moveCode == 4 && frogXIndex < 48)
                frogXIndex++;
        }
    }
}
