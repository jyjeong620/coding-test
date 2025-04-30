package junyoung.week5;

import java.util.LinkedList;

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

    public int makeHamburger(int[] ingredient) {
        int makeCount = 0;

        LinkedList<Integer> objects = new LinkedList<>();
        for (int i : ingredient) {
            objects.add(i);
            int size = objects.size();
            if (size > 4
                    && objects.getLast() == 1
                    && objects.get(size - 2) == 3
                    && objects.get(size - 3) == 2
                    && objects.get(size - 4) == 1
            ) {
                makeCount++;
                for (int j = 0; j < 4; j++) {
                    objects.removeLast();
                }
            }
        }
        return makeCount;
    }
}

