package practice;

import java.util.Stack;

public class RemoveStarFromString {

    static String formatString(String input) {

        Stack<Character> stack = new Stack<>();
        char[] arr = input.toCharArray();

        for(char c : arr) {

            if(!stack.isEmpty() && c == '*' && stack.peek() != '*')
                stack.pop();
            else
                stack.push(c);
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatString("leet**cod*e"));
    }
}
