package excel;

import java.util.HashMap;
import java.util.Map;

public class Q1StringFormatter {

    private static String formatString(String input) {

        Map<Character, Integer> charMap = new HashMap<>();
        char[] arr = input.toCharArray();

        for (char c : arr) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            output.append(entry.getKey()).append(entry.getValue());
        }

        return output.toString();
    }

    public static void main(String[] args) {

        System.out.println(formatString("aabbb"));
        System.out.println(formatString("aaaa"));
        System.out.println(formatString("a"));
        System.out.println(formatString("aabbaa"));

    }


}
