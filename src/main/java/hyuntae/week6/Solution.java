package hyuntae.week6;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] mostClosestString(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map.get(c) == null) {
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        return answer;
    }

    public int numberStringAndWords(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numbers.length; i++) {
            if (s.contains(numbers[i])) {
                s = s.replace(numbers[i], i+"");
            }
        }
        return Integer.parseInt(s);
    }

    public long calculateRestFee(int price, int money, int count) {
        long fee = 0;
        for (int i = 1; i <= count; i++) {
            fee += price * i;
        }
        long rest = fee - money;
        if (rest <= 0) {
            return 0;
        }
        return rest;
    }
}
