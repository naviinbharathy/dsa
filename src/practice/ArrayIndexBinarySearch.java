package practice;

public class ArrayIndexBinarySearch {

    static int findTarget(int[] arr, int x) {

        int low = 0, high = arr.length - 1;

        while(low <= high) {

            int mid = low + (low + high) / 2;

            if(arr[mid] == x) return mid;

            if(arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 1;

        System.out.println(findTarget(arr, target));
    }
}
