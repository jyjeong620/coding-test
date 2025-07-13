package yujin.week15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Week15Solution {
    public int makeHamburger(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int[] hamburger = new int[]{1, 2, 3, 1};
        int answer = 0;
        for (int value : ingredient) {
            stack.push(value);

            if (stack.size() < hamburger.length) {
                continue;
            }

            boolean matches = true;
            for (int i = 0; i < hamburger.length; i++) {
                if (stack.get(stack.size() - hamburger.length + i) != hamburger[i]) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                for (int i = 0; i < hamburger.length; i++) {
                    stack.pop();
                }

                answer++;
            }
        }
        return answer;
    }

    public int[][] analysisData(int[][] data, String ext, int valExt, String sortBy) {
        int extIndex = ext.equals("code") ? 0 : ext.equals("date") ? 1 : ext.equals("maximum") ? 2 : 3;
        int sortByIndex = sortBy.equals("code") ? 0 : sortBy.equals("date") ? 1 : sortBy.equals("maximum") ? 2 : 3;

        return Arrays.stream(data)
                .filter(row -> row[extIndex] < valExt)
                .sorted(Comparator.comparingInt(row -> row[sortByIndex]))
                .toArray(int[][]::new);
    }

    public int clawMachineGame(int[][] board, int[] moves) {
        int[] rowIndex = new int[board.length];
        for (int i = 0; i < rowIndex.length; i++) {
            for (int j = 0; j < rowIndex.length; j++) {
                if (board[j][i] != 0) {
                    rowIndex[i] = j;
                    break;
                }
                if (j == rowIndex.length - 1) {
                    rowIndex[i] = -1;
                }
            }
        }
        int[] dolls = new int[moves.length];
        int dollsIndex = 0;
        int answer = 0;
        for (int move : moves) {
            move = move - 1;
            if (rowIndex[move] == -1) {
                continue;
            }
            dolls[dollsIndex] = board[rowIndex[move]][move];
            if (dollsIndex != 0) {
                if (dolls[dollsIndex] == dolls[dollsIndex - 1]) {
                    answer += 2;
                    dollsIndex -= 2;
                }
            }
            rowIndex[move] = rowIndex[move] == board.length - 1 ? -1 : rowIndex[move] + 1;
            dollsIndex++;
        }
        return answer;
    }
}