package src;

public class Player extends Unit {

    int playerY;

    public Player(int playerX, int playerY) {
        super(playerX);
        this.playerY = playerY;
    }

    public int getY(){
        return playerY;
    }
}
