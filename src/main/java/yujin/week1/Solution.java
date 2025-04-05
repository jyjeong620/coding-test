package yujin.week1;

import java.util.Arrays;

public class Solution {
    public int sumOfDivisors(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        return result;
    }

    public int sumDigits(int n) {
        String[] numbers = String.valueOf(n)
                .split("");

        return Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}