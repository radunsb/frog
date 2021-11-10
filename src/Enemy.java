package src;

public class Enemy extends Unit {

    int enemyX;

    public Enemy(int enemyX) {
        super(enemyX);
    }

    //is its own separate class because we will likely add pixel art for enemies
    //if we end up going to a GUI.
}
