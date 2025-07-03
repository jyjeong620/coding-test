package yujin.week14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Week14Solution {
    public int neighbor(String[][] board, int h, int w) {
        int n = board.length;
        int answer = 0;
        int[] dh = new int[]{0, 1, -1, 0};
        int[] dw = new int[]{1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            if (h + dh[i] >= 0 && h + dh[i] < n && w + dw[i] >= 0 && w + dw[i] < n) {
                answer += board[h][w].equals(board[h + dh[i]][w + dw[i]]) ? 1 : 0;
            }
        }
        return answer;
    }

    public String notFinishedRunner(String[] participant, String[] completion) {
        Map<String, Integer> runnerMap = new HashMap<>();
        for (String runner : participant) {
            runnerMap.put(runner, runnerMap.getOrDefault(runner, 0) + 1);
        }

        for (String runner : completion) {
            runnerMap.put(runner, runnerMap.get(runner) - 1);
        }

        for (Map.Entry<String, Integer> entry : runnerMap.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return "";
    }

    public String numberPair(String x, String y) {
        Map<Character, Integer> xMap = new HashMap<>();
        for (char value : x.toCharArray()) {
            xMap.put(value, xMap.getOrDefault(value, 0) + 1);
        }

        List<Integer> pairs = new ArrayList<>();
        for (char value : y.toCharArray()) {
            if (xMap.containsKey(value) && xMap.get(value) > 0) {
                pairs.add(value - '0');
                xMap.put(value, xMap.get(value) - 1);
            }
        }

        if (pairs.isEmpty()) {
            return "-1";
        }

        if (pairs.stream().allMatch(p -> p == 0)) {
            return "0";
        }

        return pairs.stream()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}