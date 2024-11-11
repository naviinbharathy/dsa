package excel;

import java.util.HashMap;
import java.util.Map;

public class Q8NonRepeatingCharacter {

    private static Character findFirstNonRepeatingChar(String input) {

        Map<Character, Integer> charMap = new HashMap<>();

        char[] arr = input.toCharArray();

        for(char c : arr) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(char c: arr) {
            if(charMap.get(c) == 1)
                return c;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("12345"));
        System.out.println(findFirstNonRepeatingChar("abbacd"));
    }
}
