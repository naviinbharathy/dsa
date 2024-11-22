package excel;

public class Q9DistanceBetweenWords {

    private static int findMinimumDistance(String input, String word1, String word2) {

        String[] words = input.split(" ");

        int minDistance = Integer.MAX_VALUE;
        int prevIndexWord1 = -1;
        int lastIndexWord2 = -1;

        for(int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) {
                prevIndexWord1 = i;
                if (lastIndexWord2 != -1) {
                    minDistance = Math.min(minDistance, prevIndexWord1 - lastIndexWord2);
                }
            } else if (words[i].equals(word2)) {
                lastIndexWord2 = i;
                if (prevIndexWord1 != -1) {
                    minDistance = Math.min(minDistance, lastIndexWord2 - prevIndexWord1);
                }
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {

        String str = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";

        System.out.println(findMinimumDistance(str, word1, word2));

    }
}
