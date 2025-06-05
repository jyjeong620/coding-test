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

    public int splitStrings(String s) {
        int answer = 0;
        int anotherCount = 0;
        int myCount = 0;
        char myChar = 0;
        for (char c : s.toCharArray()) {
            if (myCount == 0) {
                myChar = c;
            }
            myCount += myChar == c ? 1 : 0;
            anotherCount += myChar != c ? 1 : 0;
            if (myCount == anotherCount) {
                answer++;
                myCount = 0;
                anotherCount = 0;
            }
        }
        answer += myCount == 0 & anotherCount == 0 ? 0 : 1;
        return answer;
    }
}
