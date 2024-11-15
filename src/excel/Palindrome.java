package excel;

public class Palindrome {

    static boolean isPalindrome(String input) {

        int i = 0, n = input.length() - 1;

        while(i < n) {

            if(input.charAt(i) != input.charAt(n))
                return false;

            i++;
            n--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("mom"));
    }
}
