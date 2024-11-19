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


    public static void main(String[] args) {

     //   int[] arr1 = {5, 6, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println(findMinimum(arr2));
    }
}
