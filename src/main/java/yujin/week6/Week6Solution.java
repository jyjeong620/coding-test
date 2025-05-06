package yujin.week6;

import java.util.ArrayList;
import java.util.List;

public class Week6Solution {
    public String caesarPassword(String s, int n) {
        char[] targets = s.toCharArray();
        List<Character> lowerAlphabets = new ArrayList<>();
        List<Character> upperAlphabets = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            lowerAlphabets.add((char) ('a' + i));
            upperAlphabets.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] == ' ') {
                sb.append(' ');
                continue;
            }

            if (lowerAlphabets.contains(targets[i])) {
                int index = lowerAlphabets.indexOf(targets[i]);
                int indexOfCaesar = (index + n) % 26;
                sb.append(lowerAlphabets.get(indexOfCaesar));
            } else {
                int index = upperAlphabets.indexOf(targets[i]);
                int indexOfCaesar = (index + n) % 26;
                sb.append(upperAlphabets.get(indexOfCaesar));
            }
        }

        return sb.toString();
    }
}