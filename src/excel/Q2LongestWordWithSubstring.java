package excel;

// Q2
public class Q2LongestWordWithSubstring {

    public static String findLongestWord(String[] dict, String toSearch) {

        String longestWord = "";

        for (String word : dict) {

            if(hasSubstring(word, toSearch)
                    && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    private static boolean hasSubstring(String word, String key) {

        int n = word.length();
        int m = key.length();

        int i = 0, j = 0;

        while(i < n) {

            if(word.charAt(i) == key.charAt(j)) {
                i++; j++;
            }

            if(j == m) return true;
            else if(i < n && word.charAt(i) != key.charAt(j)) {
                j = 0;
                i++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG";

        System.out.println(findLongestWord(dict, toSearch));
    }
}
