package excel;

import java.util.HashMap;
import java.util.Map;

public class Q19NumberFractionFormat {

    static String findFraction(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();

        if(numerator == 0) return "";

        if(numerator < 0 || denominator < 0)
            result.append("-");

        long num = (long) numerator;
        long den = (long) denominator;

        result.append(num / den);

        num %= den;

        if(num == 0) return result.toString();

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(num != 0) {

            if(map.containsKey(num)) {
                int startIndex = map.get(num);
                result.insert(startIndex, "(").append(")");
                break;
            }

            map.put(num, result.length());

            num *= 10;
            result.append(num / den);
            num %= den;

        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(findFraction(50, 22));
    }
}
