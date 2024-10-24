package assignment.oct7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFormatConverter {

    public static void main(String[] args) {
        String input = "aaabbbcccddc";

        Map<String, Long> resultmap =
                Stream.of(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<String, Long> map : resultmap.entrySet()) {
            System.out.print(map.getKey() + map.getValue());
        }
    }
}
