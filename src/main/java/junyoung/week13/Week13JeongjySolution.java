package junyoung.week13;

public class Week13JeongjySolution {
    public String caesarCipher(String s, int n) {
        StringBuilder sb = new StringBuilder();
        n %= 26;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char)('a' + (c - 'a' + n) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)('A' + (c - 'A' + n) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
