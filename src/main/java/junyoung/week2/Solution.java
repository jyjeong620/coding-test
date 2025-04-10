package junyoung.week2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String evenOrOdd(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public int[] getDestructionPersonalInfo(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        List<Privacy> privacyList = Arrays.stream(privacies)
                .map(Privacy::from)
                .collect(Collectors.toList());

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        int i = 1;
        for (Privacy privacy : privacyList) {
            Integer periodMonth = termMap.get(privacy.getType());
            if (privacy.isExpired(today, periodMonth)) {
                answer.add(i);
            }
            i++;
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public double average(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        return Arrays.stream(arr)
                .average()
                .orElseGet(() -> 0.0);
    }
}

class Privacy {
    private final String date;
    private final String type;

    public Privacy(String date, String type) {
        this.date = date;
        this.type = type;
    }

    public static Privacy from(String privacy) {
        String[] splitPrivacy = privacy.split(" ");
        return new Privacy(splitPrivacy[0], splitPrivacy[1]);
    }

    public String getType() {
        return type;
    }

    public boolean isExpired(String today, int periodMonth) {
        int referenceDate = countDaysFromDate(date) + periodMonth * 28;
        return countDaysFromDate(today) >= referenceDate;
    }

    public int countDaysFromDate(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}
