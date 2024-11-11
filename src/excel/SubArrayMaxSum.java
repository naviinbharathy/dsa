package excel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SubArrayMaxSum {
    static int slidingWindow(int[] arr, int k) {

        if(k > arr.length)
            return -1;

        int maxSum = 0;

        for(int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for(int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];

            if(windowSum > maxSum)
                maxSum = windowSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 10, 2, 1};
        int k = 12;

        int result = slidingWindow(arr, k);

        if(result == -1)
            System.out.println("Invalid");
        else
            System.out.println("max sum = " + result);
    }
}