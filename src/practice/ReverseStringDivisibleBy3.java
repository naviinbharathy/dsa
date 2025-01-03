package practice;

public class ReverseStringDivisibleBy3 {

    public static String reverseDivisibleByThree(String str) {

        char[] arr = str.toCharArray();
        int j = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (arr[i] % 3 == 0) {
                while (j > i) {
                    j--;
                    if (arr[j] % 3 == 0) {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        break;
                    }
                }
            }
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        String input = "12345689";
        String output = reverseDivisibleByThree(input);
        System.out.println("Reversed String : " + output);
    }
}
