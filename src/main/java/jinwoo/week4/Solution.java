package jinwoo.week4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countLessOrEqualSubstrings(String t, String p) {
        int answer = 0;
        int pLength = p.length();

        for (int i = 0; i <= t.length() - pLength; i++) {
            String sub = t.substring(i, i + pLength);
            if (sub.compareTo(p) <= 0) {
                answer++;
            }
        }

        return answer;
    }

    public int[] findNearestSameCharacter(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            int x = 0;

            if(i == 0) {
                answer[i] = -1;
                continue;
            }

            while(x < i) {
                if(arr[x] == arr[i]) {
                    answer[i] = i - x;
                }
                x += 1;
            }

            if(answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    public int divideString(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;

        char[] arr = s.toCharArray();
        char x = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                answer++;

                if (i + 1 < arr.length) {
                    x = arr[i + 1];
                }
                same = 0;
                diff = 0;
            }
        }

        if (same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}
