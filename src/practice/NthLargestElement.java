package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class NthLargestElement {

    static int findNthLargest(int[] arr, int n) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = n; i < arr.length; i++) {
            if(arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements" );
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter N, to find Nth largest");
        int n = sc.nextInt();

        System.out.println(n + "th largest element is : ");
        System.out.println(findNthLargest(arr, n));
    }
}
