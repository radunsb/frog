package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ChristiansTests2 extends JPanel implements KeyListener{
    static int frogD = 0;
    public ChristiansTests2(){
        addKeyListener(this);

    }
    public static void main(String[] args){
        ChristiansTests2 mainObject = new ChristiansTests2();
        GameLoop g = new GameLoop();
        Board b = new Board(0.2,4,4);
        JFrame frame = new JFrame("Frogger");
        Color bg = new Color(30,30,32);
        Color fg = new Color(100,210,100);
        frame.addKeyListener(mainObject);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JTextArea label = new JTextArea(b.drawBoardString());
        Font textFont = new Font("Serif", Font.PLAIN, 30);
        label.setFont(textFont);
        label.setForeground(fg);
        label.setBackground(bg);
        frame.add(label);
        b.drawBoard();
        boolean hasCollided = false;
        long time = System.currentTimeMillis();
        while(!hasCollided){
            long time2 = System.currentTimeMillis() - time;
            // Look for movement
            if(time2 > 50) { // 20 frames per second
                try {
                    b.boardShift(frogD);
                } catch (Exception e) {
                    hasCollided = true;
                    label.setText("Game over.");
                    break;
                }
                frogD = 0;
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
