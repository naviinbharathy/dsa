package excel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q7WordsStartsWithPrefix {

    private static List<String> findStringsWithPrefix(String[] arr, String prefix) {

        List<String> result = new ArrayList<>();
        int prefixLength = prefix.length();

        for (String s : arr) {
            if (s.length() >= prefixLength) {
                boolean flag = true;
                for (int i = 0; i < prefixLength; i++) {
                    if(s.charAt(i) != prefix.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) result.add(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "applet", "bread", "aper"};
        String prefix = "ap";
        System.out.println(findStringsWithPrefix(arr, prefix));
    }
}
