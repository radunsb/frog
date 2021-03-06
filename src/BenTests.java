package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BenTests extends JPanel implements KeyListener{
    static int frogD = 0;
    public BenTests(){
        addKeyListener(this);

    }
    public static void main(String[] args){
        BenTests mainObject = new BenTests();
        Game g = new Game(1);
        Board b = g.runLevel(g.getLevel());

        JFrame frame = new JFrame("Frogger");
        Color bg = new Color(30,30,32);
        Color fg = new Color(200,120,100);
        frame.addKeyListener(mainObject);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840, 680);
        JTextArea label = new JTextArea(b.drawBoardString(g.getLevel(), g.getScore(), g.getLives()));

        Font textFont = new Font(Font.MONOSPACED, Font.PLAIN, 24);
        label.setFont(textFont);
        label.setForeground(g.getColor(g.getLevel()));
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
                    if(g.getLives() > 1){
                        g.restartLevel(b);
                        g.setLives(g.getLives() - 1);
                    }
                    else {
                        hasCollided = true;
                        label.setText("Game over.");
                        break;
                    }
                }
                if(b.completeBoard()){
                    if(g.getLevel() == 5){
                        label.setText("You Win!");
                        hasCollided = true;
                        break;
                    }
                   g.setLevel(g.getLevel() + 1);
                    label.setForeground(g.getColor(g.getLevel()));
                   b = g.runLevel(g.getLevel());
                }
                frogD = 0;
                label.setText(b.drawBoardString(g.getLevel(), g.getScore(), g.getLives()));
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
