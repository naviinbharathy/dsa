package practice;

import java.util.Arrays;
import java.util.Stack;

// LC - #739
public class DailyTemperatures {

    static int[] dailyTemperatures(int[] arr) {

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < arr.length - 1; i++) {

            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
