package yujin.week15;

import java.util.Stack;

public class Week15Solution {
    public int makeHamburger(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int[] hamburger = new int[]{1, 2, 3, 1};
        int answer = 0;
        for (int value : ingredient) {
            stack.push(value);

            if (stack.size() < hamburger.length) {
                continue;
            }

            boolean matches = true;
            for (int i = 0; i < hamburger.length; i++) {
                if (stack.get(stack.size() - hamburger.length + i) != hamburger[i]) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                for (int i = 0; i < hamburger.length; i++) {
                    stack.pop();
                }

                answer++;
            }
        }
        return answer;
    }
}