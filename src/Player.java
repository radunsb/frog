package src;

public class Player extends Unit {
    int playerX;
    //index of row of frog's current position
    int playerY;
    //direction frog is currently moving
    int movement;

    public Player(int playerX, int playerY, int movement) {
        super(playerX);
        this.playerY = playerY;
        this.movement = movement;
    }

    /**
     * getter for y position
     * @return index of row frog is currently in
     */
    public int getY(){
        return playerY;
    }

    public void setX(int x){
        this.playerX = x;
    }

    public void setY(int y){
        this.playerY = y;
    }

    /**
     * Checks to see if this Player is currently colliding with a specific enemy
     * @param other Enemy potentially colliding with
     * @return true if collision is happening
     */
    public boolean checkCollision(Enemy other){
        return false;
    }
}
