package excel;

public class Q12ChessBishopTarget {

    static int findNoOfMoves(int x1, int y1, int x2, int y2) {

        // (x1, y1) bishop position
        // (x2, y2) target position

        // possible input value 0 to 7

        if((x1 + y1) % 2 != (x2 + y2) % 2)
            return 0;

        if(Math.abs(x1 - x2) == Math.abs(y1 - y2))
            return 1;
        else
            return 2;
    }

    public static void main(String[] args) {

        // inputs might be two arrays for two piece positions
        // OR inputs can be individual values passed as parameter

        System.out.println(findNoOfMoves(1, 2, 4, 5));
    }
}

