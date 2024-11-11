package excel;

import java.util.HashSet;
import java.util.Set;

public class Q7WordsStartsWithPrefix {

    private static Set<String> findStringsWithPrefix(String[] arr, String prefix) {

        Set<String> result = new HashSet<>(arr.length);
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

    /*

    Size 20

    Size 40 new array

    for(20 times)
        copy to new array
        append new val




     */
}
