package excel;

public class Q20LongestUniformSubString {


    static void findLongestUniformSubstring(String input) {

        int currentLen = 0;
        int maxLen = 0;
        int maxLenStartIndex = 0;

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {

                currentLen++;

                if (currentLen > maxLen)
                {
                    maxLen = currentLen;
                    maxLenStartIndex = i - currentLen + 1;
                }
            } else
                currentLen = 1;
        }

        System.out.println("Max substring : " + input.substring(maxLenStartIndex, maxLenStartIndex + maxLen));
        System.out.println("Max len index : " + maxLenStartIndex);
    }

    public static void main(String[] args) {

        findLongestUniformSubstring("aaabbbbCCdd");

    }
}
