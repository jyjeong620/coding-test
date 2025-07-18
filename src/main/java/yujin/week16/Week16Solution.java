package yujin.week16;

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
}
