package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputTest implements KeyListener {
    public static void main(String[] args) {

    }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        System.out.println(e);
    }
}
