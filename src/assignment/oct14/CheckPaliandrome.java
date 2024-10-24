package assignment.oct14;

public class CheckPaliandrome {

    private static boolean isPalindrome(String s) {

        for(int i = 0; i < s.length() - 1; i++) {
            if(expandFromCenter(s, i, i))
                return true;

            if(expandFromCenter(s, i, i + 1))
                return true;
        }

        return false;
    }

    private static boolean expandFromCenter(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return left < 0 && right >= s.length();
    }

    public static void main(String[] args) {
        String s = "geekkeeg";
        System.out.println(isPalindrome(s));
    }
}
