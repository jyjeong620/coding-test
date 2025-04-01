package junyoung.week1;

import java.util.stream.IntStream;

public class Solution {
    public int sumDivisor(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .sum();
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
