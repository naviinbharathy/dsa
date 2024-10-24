package assignment.oct14;

public class MedianFromArrayBS {

    public static double findMedian(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }

        int x = arr1.length;
        int y = arr2.length;
        int low = 0, high = x;

        while (low <= high) {

            int midX = (low + high) / 2;
            int midY = (x + y + 1) / 2 - midX;

            int minX = (midX == x) ? Integer.MAX_VALUE : arr1[midX];
            int minY = (midY == y) ? Integer.MAX_VALUE : arr2[midY];
            int maxX = (midX == 0) ? Integer.MIN_VALUE : arr1[midX - 1];
            int maxY = (midY == 0) ? Integer.MIN_VALUE : arr2[midY - 1];

            System.out.println("midX = " + midX);
            System.out.println("midY = " + midY);

            System.out.println("min = (" + minX + ", " + minY + ")");
            System.out.println("max = (" + maxX + ", " + maxY + ")");


            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0)
                    return ((double) Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                else
                    return (double) Math.max(maxX, maxY);
            } else if (maxX > minY)
                high = midX - 1;
            else
                low = midX + 1;

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4, 5};

        System.out.println("The median is: " + findMedian(arr1, arr2));
    }
}
