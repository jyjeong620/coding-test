package hyuntae.week19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] stockPrice(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop(); // 4 3 1 0
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }

    private static int[] dp;

    public int fibonacci(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibonacciRecursive(n);
    }

    private int fibonacciRecursive(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n <= 1) {
            return n;
        }
        return dp[n] = (fibonacci(n - 2) + fibonacci(n - 1)) % 1_234_567;
    }

    public int[][] hanoi(int n) {
        return hanoiRecursive(n, 1, 3).toArray(new int[0][]);
    }

    private List<int[]> hanoiRecursive(int n , int from, int to) {
        if(n == 1) {
            return List.of(new int[]{from, to});
        }

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoiRecursive(n - 1, from, empty));
        result.addAll(hanoiRecursive(1, from, to));
        result.addAll(hanoiRecursive(n - 1, empty, to));
        return result;
    }
}
