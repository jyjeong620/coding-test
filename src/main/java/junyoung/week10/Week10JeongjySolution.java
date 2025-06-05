package junyoung.week10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Week10JeongjySolution {
    public String[] sortByMyMind(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparing((String s) -> s.charAt(n))
                        .thenComparing(Function.identity()))
                .toArray(String[]::new);
    }

    public boolean countPAndY(String s) {
        String lowerCase = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c == 'p') {
                pCount++;
            }
            if (c == 'y') {
                yCount++;
            }
        }
        if (pCount == 0 && yCount == 0) {
            return true;
        }
        return pCount == yCount;
    }

    public int[] kNumbers(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            answer[i] = subArray[command[2] - 1];
        }
        return answer;
    }
}
