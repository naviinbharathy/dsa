package practice;

public class OceanView {

    // Brute force - O(n)

    static boolean isSeaVisible(int[] arr) {

        int length = arr.length;
        int sea = arr[length - 1];

        for(int i = 0; i <= length - 2; i++) {
            if(arr[i] > sea)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 8, 5, 6, 10 };
        System.out.println(isSeaVisible(arr));
    }
}
