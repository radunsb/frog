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
    final int rowSize = 48;

    public Row(int rowSpeed, int numEnemies) {
        this.units = new ArrayList<>();
        this.rowSpeed = rowSpeed;
        this.numEnemies = numEnemies;
        // Initializes row with all ground units
        for (int i = 0; i < rowSize; i++) {
            units.add(new Ground(i));
        }
        // Initializes enemies
        for (int i = 0; i < numEnemies; i++) {
            int rando = (int) Math.floor(rowSize*Math.random());
            units.set(rando, new Enemy(rando));
        }
    }

    /**
     * Takes numEnemies and assigns that number of enemies to random positions in the row,
     * and the rest of the units to ground
     * @param numEnemies number of enemies per row, taken from queue in GameLoop
     */
    public void fillRow(int numEnemies) {
        // (Bad) implementation in constructor
        // -Christian
    }

    /**
     * Moves every unit in row one to right, and the furthest one to the first position
     */
    public void rowShift(int frames) {
        // This implementation of row shift simply deletes the last element of the
        // ArrayList and adds it to the front of the list. This is good for effeciency
        // but bad for collision checking, as this will simply move the frog character over.
        // One approach from here would probably be to update each individual unit's
        // x-coordinates (not the frog's) and check for collision based on that.
        // Alternatively, this could iterate through the list and try to assign the unit in the
        // current location to the one in the next location. Collision testing could happen there.
        // This approach makes collision testing much more simple but the act of row shifting more
        // challenging. I personally think this approach makes more sense.
        // Below is the first (IMO bad) implementation, but it works for now
        if (frames % rowSpeed == 0) {
            units.add(0, units.remove(rowSize-1));
        }
        // rowSpeed explanation time!!! if rowspeed is set to 4, it will shift every 4 frames
        // if it is set to 1, every frame
        // if it is set to 20, once every 20 frames
        // Hope this makes sense
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Unit u : units) {
            sb.append(u.toString());
        }
        return sb.toString();
    }
}
