package assignment.oct14;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 6;

        System.out.println(findIndex(arr, x));
    }

    private static int findIndex(int[] arr, int x) {

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == x)
                return mid;

            if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
