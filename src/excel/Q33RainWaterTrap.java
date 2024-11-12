package excel;

public class Q33RainWaterTrap {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(rainWaterTrap(a));
    }

    public static int rainWaterTrap(int[] a) {
        int ans = 0;
        int left = 0;
        int right = a.length - 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while (left < right) {
            if (a[left] > leftMax)
                leftMax = a[left];

            if (a[right] > rightMax)
                rightMax = a[right];

            if (leftMax < rightMax) {
                ans += (leftMax - a[left]);
                left++;
            } else {
                ans += (rightMax - a[right]);
                right--;
            }
        }
        return ans;
    }
}
