package practice;

public class SubArrayMaxSumLengthK {

    static int maxSum(int[] arr, int k) {

        if(k > arr.length)
            return -1;

        int maxSum = 0;

        for(int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];

            if(windowSum > maxSum) maxSum = windowSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;

        System.out.println(maxSum(arr, k));
    }
}
