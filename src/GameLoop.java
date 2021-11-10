package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GameLoop implements KeyListener {

    private int score;

    /**
     * Big queue of the number of enemies hard-coded in. Basically has the numbers for every level
     * and continues through until the game is completed.
     * Will use iterator to keep track of position in queue
     */
    private PriorityQueue<ArrayList<Integer>> numEnemies = new PriorityQueue<>();

    public GameLoop() {

    }

    /**
     * Creates a new level, creating a new board for it and resetting the frog's position
     * @param numLevel current level on
     */
    public void runLevel(int numLevel) {

    }

    /**
     * Same as runLevel but is called when the frog dies to restart the current level
     * @param numLevel current level on
     */
    public void restartLevel(int numLevel){

    }

    /**
     * Gets the score for the current level based on the remaining time
     * @return level score, which will be added to total score
     */
    public int levelScore(int timeLeft){
        return -1;
    }

    /**
     * Looks for key input and returns the direction the frog should move.
     * 0 = no move
     * 1 = left
     * 2 = up
     * 3 = right
     * 4 = down
     * can be changed later if we want
     *
     * @return direction frog should move
     */
    public int frogMove() {
        return -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
