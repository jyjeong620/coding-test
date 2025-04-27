package hyuntae.week4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int sumOfDivisors(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    public int sumDigits(int n) {
        String[] numbers = String.valueOf(n).split("");
        return Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public int[] reverseNumberToArray(long n) {
        String[] nums = String.valueOf(n).split("");
        return IntStream.range(1, nums.length + 1)
                .map(i -> Integer.parseInt(nums[nums.length - i]))
                .toArray();
    }
}