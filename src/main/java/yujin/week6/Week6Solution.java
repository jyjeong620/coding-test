package yujin.week6;

public class Week6Solution {
    public String caesarPassword(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                char password = (char) ((ch - 'a' + n) % 26 + 'a');
                answer.append(password);
            } else if (Character.isUpperCase(ch)) {
                char password = (char) ((ch - 'A' + n) % 26 + 'A');
                answer.append(password);
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }
}