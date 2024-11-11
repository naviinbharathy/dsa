package excel;

import java.util.*;
import java.util.HashMap;

public class Q15HighestAverage {

    public static String[] findHighestAverage(String[][] marksArray) {

        Map<String, List<Integer>> studentMarks = new HashMap<>();

        for (String[] entry : marksArray) {

            String student = entry[0];
            int mark = Integer.parseInt(entry[1]);

            studentMarks.computeIfAbsent(student, k -> new ArrayList<>()).add(mark);
        }

        double highestAvg = Double.MIN_VALUE;
        String topStudent = "";

        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {

            String student = entry.getKey();
            List<Integer> marks = entry.getValue();

            double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0);

            if (average > highestAvg) {
                highestAvg = average;
                topStudent = student;
            }
        }

        return new String[] {topStudent, String.valueOf(highestAvg)};
    }

    public static void main(String[] args) {

        String[][] marksArray = {
                {"Charles", "84"},
                {"John", "100"},
                {"Andy", "37"},
                {"John", "23"},
                {"Charles", "20"}
        };

        System.out.println(Arrays.toString(findHighestAverage(marksArray)));
    }
}
