package practice;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubArrayMaxSum {

    static int maxSum(int[] arr, int k) {

        if(k > arr.length)
            return -1;

        int maxSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {

          //  set
        }


        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 10, 2, 1};
        int k = 3;

        System.out.println(maxSum(arr, k));
    }
}
