package excel;

// Q2
public class Q2LongestWordWithSubstring {

    public static String findLongestWord(String[] dict, String toSearch) {

        String longestWord = "";

        for (String word : dict) {
            if (word.contains(toSearch) && word.length() > longestWord.length())
                longestWord = word;
        }

        return longestWord;
    }

    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG";

        System.out.println(findLongestWord(dict, toSearch));
    }
}
