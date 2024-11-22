package excel;

public class Q11MinimumInSortedRotatedArray {

    static int findMinimum(int[] arr) {

        int low = 0, high = arr.length - 1;

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[high]) {
                low = mid + 1;
            } else
                high = mid;
        }

        return arr[low];
    }

    // 3 4 5 1 2


    public static void main(String[] args) {

        int[] arr2 = {3, 4, 5, -1, 1, 2};

        System.out.println(findMinimum(arr2));
    }
}
