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
    final int rowSize;

    public Row(int rowSpeed, int numEnemies, int rowSize) {
        this.units = new ArrayList<>();
        this.rowSpeed = rowSpeed;
        this.numEnemies = numEnemies;
        this.rowSize = rowSize;
        // Initializes row with all ground units
        for (int i = 0; i < rowSize; i++) {
            units.add(new Ground());
        }
        // Initializes enemies
        for (int i = 0; i < numEnemies; i++) {
            int rando = (int) Math.floor(rowSize*Math.random());
            setEnemy(rando);
        }
    }

    /**
     *
     * @param numFrames Number of frames processed by Board class
     * Moves every unit in row one to right, and the furthest one to the first position
     */
    public void rowShift(int numFrames, int frogX) throws Exception {
        boolean containsFrog = false;
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
                   containsFrog = true;
                }
            }
                if(units.get(rowSize-1) instanceof Player){
                    units.add(0, units.remove(rowSize-2));
                }
                else {
                    units.add(0, units.remove(rowSize - 1));
                }
            if(containsFrog) {
                if(frogX < rowSize-1) {
                    units.add(frogX, units.remove(frogX + 1));
                }
            }
        }
        // if rowspeed is set to 4, it will shift every 4 frames
        // if it is set to 1, every frame
        // if it is set to 20, once every 20 frames
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
        units.set(x, new Player());
    }

    public void setEnemy(int x) {
        units.set(x, new Enemy());
    }

    public void moveFrogLeftRight(int lr, int frogIndex) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!(units.get(frogIndex) instanceof Player)) {
            throw new IllegalArgumentException("Index given not instance of Player");
        }
        // left
        if (lr == 3 && frogIndex != 0) {
            units.add(frogIndex-1,units.remove(frogIndex));
        }
        // right
        if (lr == 4 && frogIndex < rowSize-1) {
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
        units.set(x, new Ground());
    }

    // Replaces the ground unit in a given row with a frog
    public void frogAppears(int x) {
        units.set(x, new Player());
    }
}
