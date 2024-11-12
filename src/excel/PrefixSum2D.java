package excel;

import java.util.Arrays;

public class PrefixSum2D {

    static String calculatePrefixSum(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(i == 0 && j != 0)
                    arr[i][j] = arr[i][j - 1] + arr[i][j];

                if(i != 0 && j == 0)
                    arr[i][j] = arr[i - 1][j] + arr[i][j];

                if(i != 0 && j != 0)
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + arr[i][j] - arr[i - 1][j - 1];


            }
        }

        return Arrays.deepToString(arr);
    }

    public static void main(String[] args) {

        int[][] arr =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(calculatePrefixSum(arr));
    }
}
