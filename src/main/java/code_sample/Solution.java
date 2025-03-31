package code_sample;

import java.util.Arrays;

public class Solution {

    public int solution(int[] num_list) {
        int multiply = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        int sum = Arrays.stream(num_list).sum();

        return multiply > Math.pow(sum, 2) ? 0 : 1;
    }
}

