package hyuntae.week14;

import java.util.Stack;

public class Solution {
    public int[] findNextGreaterElement(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> s = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            int number = numbers[i];
            answer[i] = -1;
            while (!s.isEmpty()) {
                int top = s.peek();
                if (top > number) {
                    answer[i] = top;
                    break;
                }
                s.pop();
            }
            s.add(number);
        }
        return answer;
    }
}
