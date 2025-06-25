package junyoung.week13;

public class Week13JeongjySolution {
    public String caesarCipher(String s, int n) {
        StringBuilder sb = new StringBuilder();
        n %= 26;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + n) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + n) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String makeWeirdText(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                result.append(j % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}
