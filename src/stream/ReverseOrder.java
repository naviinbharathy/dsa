package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseOrder {

    public static void main(String[] args) {

        List<Double> decimalList = List.of(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        decimalList = decimalList.stream().sorted(Comparator.reverseOrder()).toList();

        System.out.println(decimalList);


    }
}
