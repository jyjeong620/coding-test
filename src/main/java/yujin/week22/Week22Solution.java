package yujin.week22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Week22Solution {
    public int[] report(String[] idList, String[] report, int k) {
        Map<String, Set<String>> reporterToReport = new HashMap<>();
        for (String value : report) {
            String[] keyValue = value.split(" ");
            Set<String> reports = reporterToReport.getOrDefault(keyValue[0], new HashSet<>());
            reports.add(keyValue[1]);
            reporterToReport.put(keyValue[0], reports);
        }

        Map<String, Integer> badGuysToCount = new HashMap<>();
        for (Set<String> reportSet : reporterToReport.values()) {
            for (String value : reportSet) {
                badGuysToCount.put(value, badGuysToCount.getOrDefault(value, 0) + 1);
            }
        }

        Set<String> blockIds = badGuysToCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        int[] answer = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            String reporter = idList[i];
            Set<String> reports = reporterToReport.get(reporter);
            if (reports == null) {
                answer[i] = 0;
            } else {
                answer[i] = (int) reports.stream()
                        .filter(blockIds::contains)
                        .count();
            }
        }
        return answer;
    }
}
