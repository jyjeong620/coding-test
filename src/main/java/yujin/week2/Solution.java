package yujin.week2;

import java.util.Arrays;

public class Solution {
    public String oddOrEven(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public double average(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public long[] numberSequence(long number, int size) {
        return null;
    }
}