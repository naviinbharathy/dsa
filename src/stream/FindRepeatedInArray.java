package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindRepeatedInArray {

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("Pen", "Eraser", "Note Book", "Pen",
                        "Pencil", "Pen", "Note Book", "Pencil");

        Map.Entry<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

     //   Map.Entry<String, Long> max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Max word : " + map.getKey());
        System.out.println("count : " + map.getValue());
    }

}
