package yujin.week11;

import java.util.HashSet;
import java.util.Set;

public class Week11Solution {
    public String watermelon(int n) {
        int repeatCount = n / 2;
        StringBuilder sb = new StringBuilder();
        sb.append("수박".repeat(repeatCount));
        if (n % 2 == 1) {
            sb.append("수");
        }
        return sb.toString();
    }

    public boolean basicString(String s) {
        int length = s.length();
        if (length != 4 && length != 6) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int[] pickTwoAndSum(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }

        return numberSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}