package yujin.week24;

import java.util.Stack;

public class Week24Solution {
    public boolean correctBrackets(String s) {
        int count = 0;
        for (char value : s.toCharArray()) {
            count = value == '(' ? count + 1 : count - 1;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public int removePair(String s) {
        Stack<Character> stack = new Stack<>();
        for (char value : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(value);
            } else {
                if (stack.peek() == value) {
                    stack.pop();
                } else {
                    stack.push(value);
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
