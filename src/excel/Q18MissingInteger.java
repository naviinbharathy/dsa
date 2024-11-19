package excel;

public class Q18MissingInteger {

    static int findMissingInteger(int[] arr) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if(arr[mid] == mid)
                left = mid + 1;
            else
                right = mid -1;
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 3, 4};

        System.out.println(findMissingInteger(arr));
    }
}
