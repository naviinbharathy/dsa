package excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q29PascalTriangle {

    public static int[][] generatePascalTriangle(int numRows) {
        int[][] triangle = new int[numRows][];

        for (int row = 0; row < numRows; row++) {
            triangle[row] = new int[row + 1];
            triangle[row][0] = 1;
            triangle[row][row] = 1;

            for (int col = 1; col < row; col++) {
                triangle[row][col] =
                        triangle[row - 1][col - 1] + triangle[row - 1][col];
            }
        }

        return triangle;
    }

    public static void printPascalTriangle(int[][] triangle) {
        for (int[] row : triangle) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
    //    int[][] pascalTriangle = generatePascalTriangle(numRows);
        List<List<Integer>> pascalTriangle = generatePascalTriangle1(numRows);
    //    printPascalTriangle(pascalTriangle);
        System.out.println(pascalTriangle.toString());
    }

    // Approach 2 - Using List

    public static List<List<Integer>> generatePascalTriangle1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); //  1st element

            for (int col = 1; col < row; col++) {
                int value = triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col);
                currentRow.add(value);
            }

            if (row > 0)
                currentRow.add(1); // last element

            triangle.add(currentRow);
        }

        return triangle;
    }
}
