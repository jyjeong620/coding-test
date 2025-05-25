package hyuntae.week8;

import java.util.*;

public class Solution {
    public String participantWhoDidNotFinish(String[] participant, String[] completion) {
        String result = "";
        Map<String, Integer> runner = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            runner.putIfAbsent(participant[i], 0);
            runner.put(participant[i], runner.get(participant[i]) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            runner.put(completion[i], runner.get(completion[i]) - 1);
        }
        Set<String> keys = runner.keySet();
        for (String key : keys) {
            if (runner.get(key) > 0) {
                result = key;
            }
        }
        return result;
    }

    public int[] k_thNumber(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] tmp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tmp);
            answer[i] = tmp[command[2] - 1];
        }
        return answer;
    }

    public static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    static int max;
    static int curr;

    public Integer[] mockTest(int[] answers) {
        max = 0;
        curr = 0;
        int[] corrects = new int[RULES.length];
        for(int i = 0; i < RULES.length; i++) {
            corrects[i] = getCorrect(answers);
            if(corrects[i] > max) {
                max = corrects[i];
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < corrects.length; i++) {
            if(max == corrects[i]) {
                answer.add(i + 1);
            }
        }
        int size = answer.size();
        return answer.toArray(new Integer[size]);
    }

    static int getCorrect(int[] answers) {
        int cnt = 0;
        for(int i = 0; i < answers.length; i++) {
            int[] answer = RULES[curr];
            if(answer[i % answer.length] == answers[i]) {
                cnt++;
            }
        }
        curr++;
        return cnt;
    }
}
