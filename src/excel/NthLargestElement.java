package excel;

import java.util.PriorityQueue;
import java.util.Scanner;

public class NthLargestElement {

    static int findNthLargest(int[] arr, int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }

        for(int i = n; i < arr.length; i++) {
            if(arr[i] > queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return queue.peek();
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
