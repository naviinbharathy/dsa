package excel;

import java.util.*;
import java.util.stream.Collectors;

public class Q17StringPermutation {

    static List<String> findPermutation(String[] dict, String input) {

        List<String> result = new ArrayList<>();

        for (String word : dict) {

            if (word.length() == input.length()
                    && isPermutation(word, input))
                result.add(word);
        }

        return result;
    }

    static boolean isPermutation(String word, String input) {

        Map<Character, Long> charMap = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for(char c : input.toCharArray()) {

            if(!charMap.containsKey(c))
                return false;

            charMap.put(c, charMap.getOrDefault(c, 0L) - 1);

            if(charMap.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input = "abcd";  // Return {"abcd", "bcad"}

        System.out.println(findPermutation(dict, input));
    }
}
