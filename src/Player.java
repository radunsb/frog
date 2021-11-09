package src;

public class Player extends Unit {

    int playerX;
    int playerY;

    public Player(int playerX, int playerY) {
        super(playerX);
        this.playerY = playerY;
    }
}
