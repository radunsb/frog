package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
public class ChristiansTests2 extends JPanel implements KeyListener{
    static int frogD = 0;
    public ChristiansTests2(){
        addKeyListener(this);

    }
    public static void main(String[] args){
        ChristiansTests2 mainObject = new ChristiansTests2();
        Board b = new Board(40,17);
        b.buildBoard(0.2,2,2);
        JFrame frame = new JFrame("Frogger");
        Color bg = new Color(30,30,32);
        Color fg = new Color(200,120,100);
        frame.addKeyListener(mainObject);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840, 600);
        JTextArea label = new JTextArea(b.drawBoardString());
        Font textFont = new Font(Font.MONOSPACED, Font.PLAIN, 24);
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> frogD = 3;
            case KeyEvent.VK_UP -> frogD = 1;
            case KeyEvent.VK_RIGHT -> frogD = 4;
            case KeyEvent.VK_DOWN -> frogD = 2;
            default -> frogD = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    }
 */