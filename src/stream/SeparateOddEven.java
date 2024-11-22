package stream;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeparateOddEven {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        Map<String, List<Integer>> map = Arrays.stream(nums)
                        .boxed()
                                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        System.out.println(map);
    }
}