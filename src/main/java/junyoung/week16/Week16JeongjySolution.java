package junyoung.week16;

import java.util.Arrays;
import java.util.StringJoiner;

public class Week16JeongjySolution {
    public String makeJadenCaseString(String s) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : s.toLowerCase().split(" ", -1)) {
            if (word.isEmpty()) {
                joiner.add("");
                continue;
            }
            String string = word.substring(0, 1).toUpperCase() + word.substring(1);
            joiner.add(string);
        }
        return joiner.toString();
    }

    public String foodFighter(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i< food.length; i++) {
            int foodCount = food[i] / 2;
            sb.append(String.valueOf(i).repeat(foodCount));
        }
        String foodList = sb.toString();
        return foodList + "0" + sb.reverse();
    }

    public int[] mostNearSameString(String s) {
        int[] answer = new int[s.length()];
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                int index = c - 'a';
                if (lastSeen[index] == -1) {
                    answer[i] = -1;
                } else {
                    answer[i] = i - lastSeen[index];
                }
                lastSeen[index] = i;
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
