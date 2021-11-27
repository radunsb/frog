package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GameLoop implements KeyListener {

    private int score;

    private int frogDirection;
    /**
     * Big queue of the number of enemies hard-coded in. Basically has the numbers for every level
     * and continues through until the game is completed.
     * Will use iterator to keep track of position in queue
     */
    private PriorityQueue<ArrayList<Integer>> numEnemies = new PriorityQueue<>();
    private int level;
    private int lives;
    public GameLoop() {
        this.frogDirection = frogDirection;
        this.score = score;
        this.level = 1;
        this.lives = 3;
    }

    public GameLoop(int startingLevel){
        this.frogDirection = frogDirection;
        this.score = score;
        this.level = startingLevel;
        this.lives = 3;
    }
    /**
     * Creates a new level, creating a new board for it and resetting the frog's position
     * @param numLevel current level on
     */
    public Board runLevel(int numLevel) {
        double emptyRowCoef = 0.02*(10-numLevel);
        int rowSpeedCoef = (numLevel/2) + 1;
        int numEnemiesCoef = (numLevel/2) + 1;
        Board b = new Board(emptyRowCoef, rowSpeedCoef, numEnemiesCoef);
        return b;

    }

    /**
     * @return current level
     */
    public int getLevel(){
        return this.level;
    }

    /**
     * @param newLevel level to be set to
     */
    public void setLevel(int newLevel){
        this.level = newLevel;
    }

    /**
     * @return current score
     */
    public int getScore(){
        return this.score;
    }

    public int getLives() { return this.lives; }

    public void setLives(int newLives){
        this.lives = newLives;
    }

    /**
     * Same as runLevel but is called when the frog dies to restart the current level
     * @param b current board
     */
    public void restartLevel(Board b){
        b.removeFrog();
        b.setFrogRow(0);
        b.setFrogXIndex(24);
        b.setFrog();
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
    public int getFrogDirection(){
        return this.frogDirection;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                frogDirection = 3;
                break;
            case KeyEvent.VK_UP:
                frogDirection = 1;
                break;
            case KeyEvent.VK_RIGHT:
                frogDirection = 4;
                break;
            case KeyEvent.VK_DOWN:
                frogDirection = 2;
                break;
            default:
                frogDirection = 0;
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
