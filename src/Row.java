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
    public void rowShift(int numFrames) throws Exception {
        // If the current row is set to shift
        if (shouldShift(numFrames)) {
            for (int i = 0; i < rowSize-1; i++) {
                // Checks if there is an enemy to the left of a frog
                if (units.get(i) instanceof Enemy) {
                    if (units.get(i+1) instanceof Player) {
                        // Throws collision detected error
                        throw new Exception("Collision detected");
                    }
                    // Checks if there is a frog in the current position
                    // If so, move frog to left to compensate for row shift
                } else if (units.get(i) instanceof Player) {
                    units.add(i-1, units.remove(i));
                }
            }
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
     * @param numFrames time in frames since level has started
     * @return true if row should shift
     */
    public boolean shouldShift(int numFrames) {
        return numFrames % rowSpeed == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Unit u : units) {
            sb.append(u.toString());
        }
        return sb.toString();
    }

    // Methods for testing purposes
    public void setFrog(int x) {
        units.set(x, new Player(0,0,0));
    }

    public void setEnemy(int x) {
        units.set(x, new Enemy(x));
    }

    public void moveFrogLeftRight(int lr, int frogIndex) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!(units.get(frogIndex) instanceof Player)) {
            throw new IllegalArgumentException("Index given not instance of Player");
        }
        // left
        if (lr == 3) {
            units.add(frogIndex-1,units.remove(frogIndex));
        }
        // right
        if (lr == 4) {
            units.add(frogIndex,units.remove(frogIndex+1));
        }
        // error
        if (lr < 3 || lr > 4) {
            throw new IllegalArgumentException("This shouldn't happen");
        }
    }

    // Checks if a given x coordinate in a row contains an enemy
    public boolean hasEnemy(int x) {
        return units.get(x) instanceof Enemy;
    }

    //nReplaces the frog unit in a given row with ground
    public void frogLeaves(int x) {
        units.set(x, new Ground(x));
    }

    // Replaces the ground unit in a given row with a frog
    public void frogAppears(int x) {
        units.set(x, new Player(x,0,0));
    }
}
