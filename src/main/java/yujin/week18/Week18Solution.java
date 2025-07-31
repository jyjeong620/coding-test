package yujin.week18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week18Solution {
    public int[] privacyExpirationDate(String today, String[] terms, String[] privacies) {
        Map<String, Integer> privacyTermMap = new HashMap<>();
        for (String term : terms) {
            String[] termInfo = term.split(" ");
            privacyTermMap.put(termInfo[0], Integer.parseInt(termInfo[1]) * 28);
        }

        List<Integer> expiredPrivacy = new ArrayList<>();
        int todayTotalDays = getTotalDays(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            if (todayTotalDays >= getTotalDays(privacyParts[0]) + privacyTermMap.get(privacyParts[1])) {
                expiredPrivacy.add(i + 1);
            }
        }

        return expiredPrivacy.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getTotalDays(String date) {
        int[] dateParts = parse(date);
        return dateParts[0] * 12 * 28 + dateParts[1] * 28 + dateParts[2];
    }

    private int[] parse(String value) {
        return Arrays.stream(value.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int flexibleWorkSystem(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int max = calculateMaxTime(schedules[i]);
            int[] timelog = timelogs[i];
            int count = 0;
            for (int j = 0; j < timelog.length; j++) {
                if ((startday + j) % 7 < 6 && (startday + j) % 7 > 0) {
                    if (timelog[j] <= max) {
                        count++;
                    }
                }
            }
            if (count == 5) {
                answer++;
            }
        }
        return answer;
    }

    private int calculateMaxTime(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100 + 10;
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        return hour * 100 + minute;
    }
}
