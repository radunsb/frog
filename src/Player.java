package src;

public class Player extends Unit {
    private int playerX;
    //index of row of frog's current position
    private int playerY;
    //direction frog is currently moving
    private int movement;
    //Character used as sprite
    private final String sprite = "H";

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
        return this.getX() == other.getX();
    }

    @Override
    public String toString() {
        return sprite;
    }
}
