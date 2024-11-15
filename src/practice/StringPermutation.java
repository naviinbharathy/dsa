package practice;

/*
Write code to find if two given strings are Permutation of each other or not
 */

import java.util.HashMap;

public class StringPermutation {

    static void bubbleSort(char[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static boolean checkPermutationUsingSorting(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        bubbleSort(arr1);
        bubbleSort(arr2);

        for(int i = 0; i < arr1.length - 1; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    private static boolean checkPermutationUsingCharMap(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c , 0) + 1);

        }

        for(char c : str2.toCharArray()) {

            if(!map.containsKey(c)) return false;

            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String str1 = "BCA";
        String str2 = "CAB";

        System.out.println(checkPermutationUsingCharMap(str1, str2));
        System.out.println(checkPermutationUsingSorting(str1, str2));

    }
}
