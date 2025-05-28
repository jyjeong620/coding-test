package yujin.week9;

import java.util.stream.IntStream;

public class Week9Solution {
    public int dotProduct(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }

    public String createStrangeCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char value : s.toCharArray()) {
            if (value == ' ') {
                index = 0;
                sb.append(value);
            } else {
                sb.append(index++ % 2 == 1 ? Character.toLowerCase(value) : Character.toUpperCase(value));
            }
        }
        return sb.toString();
    }

    public int minimumRectangle(int[][] sizes) {
        int minSize = 1;
        int maxSize = 1;
        for (int[] size : sizes) {
            minSize = Math.max(Math.min(size[0], size[1]), minSize);
            maxSize = Math.max(Math.max(size[0], size[1]), maxSize);
        }
        return minSize * maxSize;
    }
}
