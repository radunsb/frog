package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BenTests extends JPanel implements KeyListener{
    int frogD = 0;
    public BenTests(){
        addKeyListener(this);

    }
    public static void main(String[] args){
        GameLoop g = new GameLoop();
        Board b = new Board();
        JFrame frame = new JFrame("Frogger");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        b.buildBoard();
        JTextArea label = new JTextArea(b.drawBoardString());
        frame.add(label);
        b.drawBoard();
        boolean hasCollided = false;
        long time = System.currentTimeMillis();
        while(!hasCollided){
            long time2 = System.currentTimeMillis() - time;
            // Look for movement
            if(time2 > 1000) {
                int movement = g.getFrogDirection();
                try {
                    b.boardShift(movement);
                } catch (Exception e) {
                    hasCollided = true;
                    break;
                }

                label.setText(b.drawBoardString());
                time = System.currentTimeMillis();
            }

        }
        b.drawBoard();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                frogD = 3;
                break;
            case KeyEvent.VK_UP:
                frogD = 1;
                break;
            case KeyEvent.VK_RIGHT:
                frogD = 4;
                break;
            case KeyEvent.VK_DOWN:
                frogD = 2;
                break;
            default:
                frogD = 0;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
