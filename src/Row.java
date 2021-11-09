package src;

import java.util.ArrayList;

public class Row {

    private ArrayList<Unit> units;
    int rowSpeed;
    int numEnemies;
    final int rowSize = 24;

    public Row(int rowSpeed, int numEnemies) {
        this.units = new ArrayList<>();
        this.rowSpeed = rowSpeed;
        this.numEnemies = numEnemies;
    }

    /**
     * Takes numEnemies and assigns that number of enemies to random positions in the row,
     * and the rest of the units to ground
     */
    public void buildRow() {
        for (int i = 0; i < rowSize; i++) {
            units.set(i, new Ground(i));
        }
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
