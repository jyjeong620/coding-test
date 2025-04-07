package yujin.week2;

import java.util.Arrays;

public class Solution {
    public String oddOrEven(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public double average(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public long[] numberSequence(int x, int n) {
        long[] numbers = new long[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = (long) x * (i + 1);
        }
        return numbers;
    }
}