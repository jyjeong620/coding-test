package yujin.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String oddOrEven(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public double average(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public long[] numberSequence(int x, int n) {
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (long) x * (i + 1);
        }
        return numbers;
    }

    public int[] memoryPoints(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int point = 0;
            for (int j = 0; j < photo[i].length; j++) {
                for (int n = 0; n < name.length; n++) {
                    if (name[n].equals(photo[i][j])) {
                        point += yearning[n];
                    }
                }
            }
            answer[i] = point;
        }

        return answer;
    }

    public String cardBundle(String[] cards1, String[] cards2, String[] goal) {
        List<String> cards1AsList = new ArrayList<>(Arrays.asList(cards1));
        List<String> cards2AsList = new ArrayList<>(Arrays.asList(cards2));

        for (String s : goal) {
            if (!cards1AsList.isEmpty() && s.equals(cards1AsList.get(0))) {
                cards1AsList.remove(0);
                continue;
            }

            if (!cards2AsList.isEmpty() && s.equals(cards2AsList.get(0))) {
                cards2AsList.remove(0);
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}