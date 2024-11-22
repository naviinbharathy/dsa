package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddStringPrefixAndSuffix {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String result = list.stream().collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);
    }
}
