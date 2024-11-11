package excel;

public class Q5MedianFromArray {

    private static int findMedian(int[] arr1, int[] arr2) {

        int[] merged = merge(arr1, arr2);

        int length = merged.length;
        int midIndex = (length) / 2;

        if (length % 2 == 0)
            return (merged[midIndex - 1] + merged[midIndex]) / 2;
        else
            return merged[midIndex];
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n || j < m) {
            if (i < n && (j >= m || arr1[i] <= arr2[j]))
                merged[k++] = arr1[i++];
            else
                merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 5, 8};
        int[] arr2 = {10, 12, 14, 16, 18, 20};

        System.out.println(findMedian(arr1, arr2));
    }
}
