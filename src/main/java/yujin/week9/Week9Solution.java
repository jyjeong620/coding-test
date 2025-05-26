package yujin.week9;

import java.util.stream.IntStream;

public class Week9Solution {
    public int dotProduct(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }
}
