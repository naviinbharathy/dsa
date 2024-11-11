package excel;

import java.util.Arrays;

public class Q4StringTraversing {

    public static int[] coordinatesFinder(int x, int y, String directions) {

        String[] movingCommands = beautifyInput(directions);

        for (String cmd : movingCommands) {

            int count = 1;

            if (cmd.contains("x")) {
                count = Integer.parseInt(cmd.split("x")[0]);
                cmd = getCmd(cmd);
            }

            for (int j = 0; j < count; j++) {
                int[] currentCoordinates = move(x, y, cmd);
                x = currentCoordinates[0];
                y = currentCoordinates[1];
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(coordinatesFinder(0, 0, "UUU")));
        System.out.println(Arrays.toString(coordinatesFinder(0, 0, "URRDDL")));
        System.out.println(Arrays.toString(coordinatesFinder(0, 0, "DOWN UP 2xRIGHT DOWN 3xLEFT")));
    }

    private static int[] move(int x, int y, String cmd) {
        switch (cmd) {
            case "U" -> y++;
            case "D" -> y--;
            case "L" -> x--;
            case "R" -> x++;
        }
        return new int[]{x, y};
    }

    private static String[] beautifyInput(String directions) {
       /* directions = directions.replaceAll("UP", "U")
                .replaceAll("DOWN", "D")
                .replaceAll("LEFT", "L")
                .replaceAll("RIGHT", "R");*/

        return directions.contains("x") ? directions.split(" ") : directions.split("");
    }

    public static String getCmd(String cmd) {
        int index = cmd.indexOf('x');
        return (index == -1) ? cmd : cmd.substring(index + 1);
    }
}
