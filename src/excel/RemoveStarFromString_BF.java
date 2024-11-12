package excel;

public class RemoveStarFromString_BF {

    public static String removalFromLtoR(String str) {

        if (str.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '*') {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {
        String str = "xerase*****";
        System.out.println(removalFromLtoR(str));

        String str1 = "leet**cod*e";
        System.out.println(removalFromLtoR(str1));

    }
}
