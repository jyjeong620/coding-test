package hyuntae.week5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public String card(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for (String card1: cards1) {
            q1.add(card1);
        }
        for (String card2: cards2) {
            q2.add(card2);
        }
        for (String str: goal) {
            if (!q1.isEmpty() && q1.peek().equals(str)) {
                q1.poll();
                continue;
            }

            if (!q2.isEmpty() && q2.peek().equals(str)) {
                q2.poll();
                continue;
            }
            answer = "No";
            break;
        }
        return answer;
    }

    public int[] memoryScore(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameScore.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            answer[i] = calculateScore(nameScore, photo[i]);
        }
        return answer;
    }

    private int calculateScore(Map<String, Integer> nameScore, String[] names) {
        int score = 0;
        for (String name: names) {
            score += nameScore.getOrDefault(name, 0);
        }
        return score;
    }

    public int smallSubstrings(String t, String p) {
        int answer = 0;
        long targetNumber = Long.parseLong(p);
        int size = p.length();
        int arrSize = t.length() - size + 1;
        for (int i = 0; i < arrSize; i++) {
            long num = Long.parseLong(t.substring(i, i + size));
            if (targetNumber >= num) {
                answer++;
            }
        }
        return answer;
    }
}
