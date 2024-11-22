package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindMultiplesOfN {

    public static void main(String[] args) {

        int x = 5;

        List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        List<Integer> result = list.stream().filter(n -> n % x == 0).toList();

        System.out.println(result);
    }
}
