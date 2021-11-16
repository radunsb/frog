package src;

public class BenTests {
    public static void main(String[] args){
        Board b = new Board();
        b.buildBoard();
        b.setFrog();
        b.drawBoard();
        boolean hasCollided = false;
        long time = System.currentTimeMillis();
        while(!hasCollided){
            long time2 = System.currentTimeMillis() - time;
            // Look for movement
            if(time2 > 1000) {
                try {
                    b.boardShift((int)(Math.random()*5));
                } catch (Exception e) {
                    hasCollided = true;
                    break;
                }

                b.drawBoard();
                time = System.currentTimeMillis();
            }

        }
        b.drawBoard();
    }
}
