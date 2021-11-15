package src;

public class BenTests {
    public static void main(String[] args){
        Board b = new Board();
        b.buildBoard();
        b.drawBoard();
        b.setFrog(5);
        b.drawBoard();
        boolean hasCollided = false;
        long time = System.currentTimeMillis();
        while(!hasCollided){
            long time2 = System.currentTimeMillis() - time;
            if(time2 > 1000) {
                try {
                    b.boardShift(0);
                } catch (Exception e) {
                    hasCollided = true;
                    break;
                }
                b.drawBoard();
                time = System.currentTimeMillis();
            }

        }
    }
}
