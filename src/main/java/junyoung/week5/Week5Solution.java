package junyoung.week5;

public class Week5Solution {
    public String ourPassword(String s, String skip, int index) {
        char[] inputs = s.toCharArray();
        String alpha = removeSkip(skip);

        StringBuilder sb = new StringBuilder();
        for (char input : inputs) {
            int oldIndex = alpha.indexOf(input);
            int newIndex = (oldIndex + index) % alpha.length();
            char c = alpha.charAt(newIndex);
            sb.append(c);
        }

        return sb.toString();
    }

    private String removeSkip(String skip) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (String s : skip.split("")) {
            alpha = alpha.replace(s, "");
        }
        return alpha;
    }
}

