package src;

public class Main {

    public static void main(String[] args) {
        boolean gameRunning = true;
        int levelOn = 1;
        GameLoop game = new GameLoop();
        game.runLevel(levelOn);
    }


}
