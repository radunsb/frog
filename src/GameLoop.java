package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLoop implements KeyListener {

    private int score;

    public GameLoop() {

    }

    /**
     * Creates a new level, creating a new board for it
     */
    public void runLevel() {
        Board b = new Board();
        b.buildBoard();
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
