package junyoung.week1;

import java.util.stream.IntStream;

public class Solution {
    public int sumDivisor(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .sum();
    }
}
