package stream;

import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 1, 3, 4, 5, 6);

        List<Integer> distinct = list.stream()
                .distinct().toList();

        System.out.println(distinct);
    }
}
