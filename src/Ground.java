package src;

public class Ground extends Unit {

    int groundX;

    private final String sprite = "_";

    public Ground(int groundX) {
        super(groundX);
    }

    @Override
    public String toString() {
        return sprite;
    }
}
