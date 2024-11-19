package excel;

import java.util.Arrays;

public class Q21AddTwoFractions {

    static int[] addFractions(int num1, int den1, int num2, int den2) {

        int num = (num1 * den2) + (num2 * den1);
        int den = den1 * den2;

        int gcd = findGCD(num, den);

        int simplifiedNum = num / gcd;
        int simplifiedDen = den / gcd;

        return new int[]{simplifiedNum, simplifiedDen};
    }

    static int findGCD(int a, int b) {

        if(a == 0)
            return b;

        return findGCD(b % a, a);
    }

    public static void main(String[] args) {

        int num1 = 1, den1 = 3;
        int num2 = 3, den2 = 9;

        int[] result = addFractions(num1, den1, num2, den2);

        System.out.println(Arrays.toString(result));
    }
}
