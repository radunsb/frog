package src;

public abstract class Unit {

    @Override
    public String toString() {
        return getSprite();
    }

    public abstract String getSprite();
}
