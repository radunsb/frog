package src;

import java.awt.*;

import java.util.HashMap;


public class GameLoop{

    private int score;

    private int frogDirection;

    private HashMap<Integer, Color> colors = new HashMap<>();

    private int level;
    private int lives;
    public GameLoop() {
        this.frogDirection = frogDirection;
        this.score = score;
        this.level = 1;
        this.lives = 3;
        this.colors = colors;
        this.colors.put(1, new Color(157, 37, 37));
        this.colors.put(2, new Color(37, 134, 22));
        this.colors.put(3, new Color(155, 110, 29));
        this.colors.put(4, new Color(126, 26, 159));
        this.colors.put(5, new Color(43, 45, 185));
    }

    public GameLoop(int startingLevel){
        this.frogDirection = frogDirection;
        this.score = score;
        this.level = startingLevel;
        this.lives = 3;
        this.colors = colors;
        this.colors.put(1, new Color(113, 52, 52));
        this.colors.put(2, new Color(37, 134, 22));
        this.colors.put(3, new Color(155, 110, 29));
        this.colors.put(4, new Color(126, 26, 159));
        this.colors.put(5, new Color(43, 45, 185));
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

    public void setScore(int newScore){
        this.score = newScore;
    }

    public int getLives() { return this.lives; }

    /**
     *
     * @param level current level player is on
     * @return The color associated with the level
     */
    public Color getColor(int level){
        return this.colors.get(level);
    }

    public void setLives(int newLives){
        this.lives = newLives;
    }

    /**
     * Same as runLevel but is called when the frog dies to restart the current level
     * @param b current board
     */
    public void restartLevel(Board b){
        b.setBoardScore(300);
        b.removeFrog();
        b.setFrogRow(0);
        b.setFrogXIndex(24);
        b.setFrog();
    }
}

