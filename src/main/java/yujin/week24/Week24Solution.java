package yujin.week24;

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
}
