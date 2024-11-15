package practice;

public class MinimumSubArray {

    public static int findLengthOfTheShortestSubArray(int[] arr, int k) {
        int minLength = Integer.MAX_VALUE;
        int[] prefixSum = calculatePrefixSum(arr);

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int sum = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);

                if (sum == k) {
                    minLength = Math.min(minLength, end - start + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static int[] calculatePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10, 2, 1};
        int k = 12;

        System.out.println(findLengthOfTheShortestSubArray(arr, k));
    }
}
