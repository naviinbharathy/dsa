package excel;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NthSmallestElement {

    static int findNthSmallest(int[] arr, int n ) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }

        for(int i = n; i < arr.length; i++) {
            if(arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {

    /*    Scanner sc = new Scanner(System.in);

        System.out.println("array size:");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("nth smallest to find");
        int n = sc.nextInt();
*/

        int[] arr = {2, 5, 3, 6, 8};
        int n = 4;

        System.out.println(findNthSmallest(arr, n));
    }
}
