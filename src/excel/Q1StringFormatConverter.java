package excel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Q1
public class Q1StringFormatConverter {

    private static String format(String input) {

        StringBuilder sb = new StringBuilder();

        Map<String, Long> charMap =
                Stream.of(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<String, Long> e : charMap.entrySet()) {
            sb.append(e.getKey());
            sb.append(e.getValue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbbcccddc";

        System.out.println(format(input));
    }
}
