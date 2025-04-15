package yujin.week3;

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
}