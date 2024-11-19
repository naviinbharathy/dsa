package excel;

import practice.ArrayIndexBinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q16IPAddress {

    static String findMaxOccuranceIp(String[] logs) {

        Map<String, Integer> map = new HashMap<>();

        for(String log : logs) {

            String ip = log.split(" ")[0];

            if(isValidIP(ip))
                map.put(ip, map.getOrDefault(ip, 0) + 1);
        }

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    static boolean isValidIP(String ip) {

        String[] parts = ip.split("\\.");

        if(parts.length != 4) return false;

        for(String part : parts) {
            if(part.isEmpty() || (part.length() > 1 && part.startsWith("0")))
                return false;

            try {
                int num = Integer.parseInt(part);
                return num > -1 && num < 256; // 0 to 255
            } catch (NumberFormatException e) {
                return false;
            }

        }

        /*Arrays.stream(parts).allMatch(part -> {
            try {
                int num = Integer.parseInt(part);
                return num >= 0 && num <= 255;   // 0 to 255
            } catch (NumberFormatException e) {
                return false;
            }
        });*/

        return false;
    }

    public static void main(String[] args) {

        String [] logs = {
                "10.0.0.1 bytes=32 time=50ms TTL=63",
                "10.0.0.2 bytes=32 time=50ms TTL=73",
                "10.0.0.4 bytes=32 time=50ms TTL=83",
                "10.0.0.2 bytes=32 time=50ms TTL=93",
        };

        System.out.println(findMaxOccuranceIp(logs));
    }
}
