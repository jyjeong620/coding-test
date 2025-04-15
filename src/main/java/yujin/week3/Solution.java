package yujin.week3;

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
        long answer = 0;
        return answer;
    }
}