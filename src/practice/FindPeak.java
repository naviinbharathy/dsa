package practice;

// find peak

public class FindPeak {

    private static int findPeak(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;

        if ((mid == 0 || arr[mid] > arr[mid - 1])
                && (mid == arr.length - 1 || arr[mid] > arr[mid + 1]))
            return mid;

        if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeak(arr, left, mid - 1);
        }

        return findPeak(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1};
        int index = findPeak(arr, 0, arr.length - 1);

        System.out.println("Peak index : " + index);
    }

}
