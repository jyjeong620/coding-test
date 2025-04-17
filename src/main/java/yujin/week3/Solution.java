package yujin.week3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class Solution {
    public int findNumberWithRemainderOne(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return n;
    }

    public int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public long sumBetween(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return LongStream.rangeClosed(min, max).sum();
    }

    public int[] nearestSameCharacter(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (indexMap.containsKey(value)) {
                answer[i] = i - indexMap.get(value);
            } else {
                answer[i] = -1;
            }
            indexMap.put(value, i);
        }
        return answer;
    }
}