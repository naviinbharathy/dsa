package excel;

public class Q10ATOIConvertor {

    private static int convertATOI(String input) {

        char[] arr = input.toCharArray();
        int result = 0;
        int sign = 1;
        int i = 0;

        if (arr[0] == '-') {
            sign *= -1;
            i++;
        }

        for (; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9')
                result = (result * 10) + (arr[i] - '0');
            else
                return -1;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(convertATOI("123"));
        System.out.println(convertATOI("-123"));
        System.out.println(convertATOI("1a23"));
    }
}
