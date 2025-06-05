package yujin.week10;

import java.util.HashSet;
import java.util.Set;

public class Week10Solution {
    public String secretCode(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        for (char c : skip.toCharArray()) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char value : s.toCharArray()) {
            char result = value;
            int count = 0;
            while (count < index) {
                result = (char) ((result - 'a' + 1) % 26 + 'a');
                if (!set.contains(result)) {
                    count++;
                }
            }
            sb.append(result);
        }
        return sb.toString();
    }

    public boolean countOfPAndY(String s) {
        String upperS = s.toUpperCase();
        int countOfP = 0;
        int countOfY = 0;
        for (char c : upperS.toCharArray()) {
            countOfP += c == 'P' ? 1 : 0;
            countOfY += c == 'Y' ? 1 : 0;
        }
        return countOfP == countOfY;
    }
}
