package excel;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumInEachSlidingWindow {

    public static int[] minimumSlidingWindow(int[] a, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        int size = a.length;
        int r = 0;
        int[] result = new int[size - k + 1];

        for (int i = 0; i < size; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && a[q.peekLast()] > a[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                result[r++] = a[q.peek()];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {9, 1, 3, -1, 5, 3, 6, 7};
        int k = 3;

        int[] result = minimumSlidingWindow(a, k);
        System.out.println(Arrays.toString(result));
    }
}
