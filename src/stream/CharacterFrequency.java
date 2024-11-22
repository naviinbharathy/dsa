package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static void main(String[] args) {

        // FROM ARRAY

        String input = "aabbbaac";

        Map<Character, Long> map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(map);

        // FROM LIST

        List<String> list = List.of("apple", "banana", "orange", "apple");

        // not coming in sorted order
        Map<String, Long> map1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map1);
    }
}
