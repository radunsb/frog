package src;

import java.util.ArrayList;

public class Row {
    //each row is filled with an arraylist of units, some of which get set to enemy and the rest to ground
    private ArrayList<Unit> units;
    //after how many frames does this row update position
    int rowSpeed;
    //number of enemies in this row
    int numEnemies;
    //width of board/length of row
    final int rowSize = 24;

    public Row(int rowSpeed, int numEnemies) {
        this.units = new ArrayList<>();
        this.rowSpeed = rowSpeed;
        this.numEnemies = numEnemies;
    }

    /**
     * Takes numEnemies and assigns that number of enemies to random positions in the row,
     * and the rest of the units to ground
     * @param numEnemies number of enemies per row, taken from queue in GameLoop
     */
    public void fillRow(int numEnemies) {

    }

    /**
     * Moves every unit in row one to right, and the furthest one to the first position
     */
    public void rowShift() {

    }

    /**
     * Takes the time and uses the row's speed to determine if it should shift
     *
     * @param time time in ms since level has started
     * @return true if row should shift
     */
    public boolean shouldShift(int time) {
        return false;
    }
}
