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
}
