package src;

import java.util.ArrayList;

public class ChristiansTests {
    public static void main(String[] args) {
//        ArrayList<Row> rs = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            rs.add(new Row(1,0));
//        }
//        StringBuilder sb = new StringBuilder();
//        for (Row r : rs) {
//            sb.append(r.toString() + "\n");
//        }
//        System.out.print(sb.toString());


        // Testing initializing a board. Hardcoded difficulty values in their respective classes
        Board b = new Board();
        b.buildBoard();
        b.drawBoard();
        // Testing shifting rows
        for (int i = 0; i < 3; i++) {
            System.out.println();
            b.boardShift(0);
            b.drawBoard();
        }
    }
}
