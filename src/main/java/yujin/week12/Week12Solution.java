package yujin.week12;

import java.util.Arrays;

public class Week12Solution {
    public int addNotExistsNumbers(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

    public String pickMiddleValue(String s) {
        int defaultIndex = s.length() / 2;

        if (s.length() % 2 == 1) {
            return s.substring(defaultIndex, defaultIndex + 1);
        } else {
            return s.substring(defaultIndex - 1, defaultIndex + 1);
        }
    }

    public String sortDescending(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] reverseChars = new char[chars.length];
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseChars[index++] = chars[i];
        }

        return String.valueOf(reverseChars);
    }
}
