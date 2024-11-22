package stream;

import java.util.Arrays;
import java.util.List;

public class MinMaxSumProduct {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        int[] arr = {45, 12, 56, 15, 24, 75, 31, 89};

        int min = list.stream().min(Integer::compare).orElse(0);
        int max = Arrays.stream(arr).boxed().max(Integer::compare).get();

        System.out.println("Min : " + min);
        System.out.println("Max : " + max);

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum : " + sum);

        int product = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product : " + product);

        int i = 1234;
        int sumStr = Arrays.stream(String.valueOf(i).split(""))
                .mapToInt(Integer::parseInt).sum();

        System.out.println("Sum str : " + sumStr);

    }
}
