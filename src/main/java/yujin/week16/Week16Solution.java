package yujin.week16;

import java.util.HashMap;
import java.util.Map;

public class Week16Solution {
    public String pushKeypad(int[] numbers, String hand) {
        int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int[] leftHandPosition = new int[]{3, 0}; // row, col
        int[] rightHandPosition = new int[]{3, 2};

        boolean isLeftHand = hand.equals("left");
        StringBuilder sb = new StringBuilder(numbers.length);
        for (int number : numbers) {
            int[] targetPosition = findPosition(keypad, number);

            if (targetPosition[1] == 0) {
                leftHandPosition = targetPosition;
                sb.append("L");
            } else if (targetPosition[1] == 2) {
                rightHandPosition = targetPosition;
                sb.append("R");
            } else {
                int leftHandMoveCount = Integer.max(targetPosition[0], leftHandPosition[0]) - Integer.min(targetPosition[0], leftHandPosition[0]) + Integer.max(targetPosition[1], leftHandPosition[1]) - Integer.min(targetPosition[1], leftHandPosition[1]);
                int rightHandMoveCount = Integer.max(targetPosition[0], rightHandPosition[0]) - Integer.min(targetPosition[0], rightHandPosition[0]) + Integer.max(targetPosition[1], rightHandPosition[1]) - Integer.min(targetPosition[1], rightHandPosition[1]);

                if (leftHandMoveCount < rightHandMoveCount || isLeftHand && leftHandMoveCount == rightHandMoveCount) {
                    leftHandPosition = targetPosition;
                    sb.append("L");
                } else {
                    rightHandPosition = targetPosition;
                    sb.append("R");
                }
            }
        }

        return sb.toString();
    }

    private int[] findPosition(int[][] keypad, int target) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public String kakaoti(String[] survey, int[] choices) {
        Map<Character, Integer> kakaotiScores = new HashMap<>();
        kakaotiScores.put('R', 0);
        kakaotiScores.put('T', 0);
        kakaotiScores.put('C', 0);
        kakaotiScores.put('F', 0);
        kakaotiScores.put('J', 0);
        kakaotiScores.put('M', 0);
        kakaotiScores.put('A', 0);
        kakaotiScores.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            char[] sur = survey[i].toCharArray();
            if (choice < 4) {
                kakaotiScores.put(sur[0], kakaotiScores.get(sur[0]) + 4 - choice);
            } else if (choice > 4) {
                kakaotiScores.put(sur[1], kakaotiScores.get(sur[1]) + choice - 4);
            }
        }

        String[] indicators = new String[]{"RT", "CF", "JM", "AN"};
        StringBuilder sb = new StringBuilder();
        for (String indicator : indicators) {
            char[] it = indicator.toCharArray();
            if (kakaotiScores.get(it[0]) >= kakaotiScores.get(it[1])) {
                sb.append(it[0]);
            } else {
                sb.append(it[1]);
            }
        }

        return sb.toString();
    }
}
