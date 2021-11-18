package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Main extends JPanel implements KeyListener {

    public Main(){
        addKeyListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frogger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        boolean gameRunning = true;
        int levelOn = 1;
        GameLoop game = new GameLoop();
        game.runLevel(levelOn);
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
