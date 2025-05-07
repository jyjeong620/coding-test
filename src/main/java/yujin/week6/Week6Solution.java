package yujin.week6;

import java.util.Arrays;

public class Week6Solution {
    public String caesarPassword(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                char password = (char) ((ch - 'a' + n) % 26 + 'a');
                answer.append(password);
            } else if (Character.isUpperCase(ch)) {
                char password = (char) ((ch - 'A' + n) % 26 + 'A');
                answer.append(password);
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    public int budget(int[] d, int budget) {
        int answer = 0;
        int totalD = 0;
        Arrays.sort(d);
        for (int i : d) {
            if (totalD + i > budget) {
                break;
            } else {
                answer++;
                totalD += i;
            }
        }

        return answer;
    }
}