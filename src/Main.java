package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Main extends JPanel implements KeyListener {
    static int frogD = 0;


    public Main() {
        addKeyListener(this);
    }

    public static void main(String[] args) {

        /**
         * Setting up the JFrame, starting the Game and running the first level
         */
        Main mainObject = new Main();
        //There are only 5 levels, so don't make startingLevel > 5
        Game g = new Game(1);
        Board b = g.runLevel(g.getLevel());

        JFrame frame = new JFrame("Frogger");
        Color bg = new Color(30, 30, 32);
        //More JFrame set up
        Font textFont = new Font(Font.MONOSPACED, Font.PLAIN, 24);
        frame.addKeyListener(mainObject);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840, 680);
        //This is what the board gets drawn to, will be updated every frame
        JTextArea label = new JTextArea(b.drawBoardString(g.getLevel(), g.getScore(), g.getLives()));


        label.setFont(textFont);
        label.setForeground(g.getColor(g.getLevel()));
        label.setBackground(bg);
        frame.add(label);

        boolean hasCollided = false;
        long time = System.currentTimeMillis();
        while (!hasCollided) {
            long time2 = System.currentTimeMillis() - time;
            // Look for movement
            if (time2 > 50) { // 20 frames per second
                //Tries to shift the board, if it can't do it, it assumes that the frog has hit an enemy
                //Well aware this isn't a great way to do collision testing
                try {
                    b.boardShift(frogD);
                } catch (Exception e) {
                    //If you have more than one life, lose a life and restart level
                    if (g.getLives() > 1) {
                        g.restartLevel(b);
                        g.setLives(g.getLives() - 1);

                    }
                    //Otherwise you get a game over
                    else {
                        hasCollided = true;
                        label.setText("Game over.\nScore: " + g.getScore());
                        break;
                    }
                }
                //If the player has finished the level
                if (b.completeBoard()) {
                    //Add current levels score to the overall score
                    g.setScore(g.getScore() + b.getBoardScore());
                    //If you beat level 5, add an extra 100 points and end the game
                    if (g.getLevel() == 5) {
                        g.setScore(g.getScore() + 100);
                        label.setText("You Win!\nScore: " + g.getScore());
                        hasCollided = true;
                        break;
                    }
                    //Run the next level and update the color
                    g.setLevel(g.getLevel() + 1);
                    label.setForeground(g.getColor(g.getLevel()));
                    b = g.runLevel(g.getLevel());
                }
                //Reset some other stuff and update the label
                b.setBoardScore(b.getBoardScore() - 1);
                frogD = 0;
                label.setText(b.drawBoardString(g.getLevel(), b.getBoardScore(), g.getLives()));
                time = System.currentTimeMillis();
            }

        }
    }





    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Runs the user input system, assigns a value to frogD based on the key the user is entering.
     * If they are not pressing a useful key, frogD defaults to 0
     */
    @Override
    public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> frogD = 3;
                case KeyEvent.VK_UP, KeyEvent.VK_W -> frogD = 1;
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> frogD = 4;
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> frogD = 2;
                default -> frogD = 0;
            }
        }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
