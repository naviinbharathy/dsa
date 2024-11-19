package excel;

public class Q22ClimbStairs {

    static int countStairs(int n) {

        int last1 = 1;
        int last2 = 1;

        for(int i = 2; i <= n; i++) {

            int current = last1 + last2;
            last2 = last1;
            last1 = current;
        }

        return last1;
    }

    public static void main(String[] args) {

        System.out.println(countStairs(4));
    }
}
