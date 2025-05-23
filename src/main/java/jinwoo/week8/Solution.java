package jinwoo.week8;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public String personalityTypeCheck(String[] survey, int[] choices) {
        String answer = "";

        HashMap<String, Integer> personalityType = new HashMap<>();
        personalityType.put("R", 0);
        personalityType.put("T", 0);
        personalityType.put("C", 0);
        personalityType.put("F", 0);
        personalityType.put("J", 0);
        personalityType.put("M", 0);
        personalityType.put("A", 0);
        personalityType.put("N", 0);

        for(int i = 0; i < survey.length; i++) {
            String target = survey[i];
            char leftTarget = target.charAt(0);
            char rightTarget = target.charAt(1);

            if(choices[i] < 4) {
                int score = personalityType.getOrDefault(String.valueOf(leftTarget), 0) + (4 - choices[i]);
                personalityType.put(String.valueOf(leftTarget), score);
            } else if (choices[i] > 4) {
                int score = personalityType.getOrDefault(String.valueOf(rightTarget), 0) + (choices[i] - 4);
                personalityType.put(String.valueOf(rightTarget), score);
            } else {
                continue;
            }
        }

        if(personalityType.get("R") >= personalityType.get("T")) {
            answer += "R";
        } else {
            answer += "T";
        }
        if(personalityType.get("C") >= personalityType.get("F")) {
            answer += "C";
        } else {
            answer += "F";
        }
        if(personalityType.get("J") >= personalityType.get("M")) {
            answer += "J";
        } else {
            answer += "M";
        }
        if(personalityType.get("A") >= personalityType.get("N")) {
            answer += "A";
        } else {
            answer += "N";
        }

        return answer;
    }

    public int[] getReportResults(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // key: 신고받은 사람, value: 신고한 사람들
        HashMap<String, HashSet<String>> reportIdMap = new HashMap<>();

        for(String re: report) {
            String[] all = re.split(" ");
            String doReportId = all[0];
            String getReportId = all[1];
            reportIdMap.computeIfAbsent(getReportId, v -> new HashSet<>()).add(doReportId);
        }

        List<String> idList = List.of(id_list);
        reportIdMap.entrySet().stream()
                .filter(doIds -> doIds.getValue().size() >= k)
                .forEach(it -> {
                    HashSet<String> doReportIdSet = it.getValue();
                    doReportIdSet.forEach(id -> {
                        int index = idList.indexOf(id);
                        answer[index] += 1;
                    });
                });

        return answer;
    }

    public int findNumberWithRemainderOne(int n) {
        int answer = 2;

        while(true) {
            if(n % answer == 1) {
                break;
            }
            answer++;
        }

        return answer;
    }
}
