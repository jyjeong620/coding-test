package jinwoo.week12;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int innerProduct(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public String findIncompleteRunner(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completeMap = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
            completeMap.put(completion[i], completeMap.getOrDefault(completion[i], 0) + 1);
        }
        Map<String, Integer> participantMap = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
        }


        for(int i = 0; i < completion.length; i++) {
            String name = completion[i];
            Integer nameCount = completeMap.get(name);
            if(nameCount > 0) {
                participantMap.put(name, participantMap.get(name) - 1);
                completeMap.put(name, completeMap.get(name) - 1);
            }
        }

        answer = participantMap.entrySet().stream()
        .filter(e -> e.getValue() > 0)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

        return answer;
    }

    public int budget(int[] d, int budget) {
        int answer = 0;
        List<Integer> requestList = new ArrayList<>();
        for(int request : d) {
            requestList.add(request);
        }

        List<Integer> orderRequestList = requestList.stream()
        .sorted()
        .collect(Collectors.toList());

        for(int request: orderRequestList) {
            if(budget >= request) {
                budget = budget - request;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
