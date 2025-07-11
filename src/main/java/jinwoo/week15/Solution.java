package jinwoo.week15;

import java.util.*;

public class Solution {
    public String[] secretMap(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            int[] secretArr1 = new int[n];
            int arr1Num = arr1[i];
            int index1 = n - 1;
            while(arr1Num != 0) {
                int x = arr1Num / 2;
                int y = arr1Num % 2;

                secretArr1[index1] = y;
                arr1Num = x;
                index1 -= 1;
            }

            int[] secretArr2 = new int[n];
            int arr2Num = arr2[i];
            int index2 = n - 1;
            while(arr2Num != 0) {
                int x = arr2Num / 2;
                int y = arr2Num % 2;

                secretArr2[index2] = y;
                arr2Num = x;
                index2 -= 1;
            }

            String result = "";
            for(int j = 0; j < n; j++) {
                if(secretArr1[j] + secretArr2[j] != 0) {
                    result += "#";
                } else {
                    result += " ";
                }
            }
            answer[i] = result;
        }

        return answer;
    }

    public int craneDollGame(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> picks = new LinkedList<>();

        for(int i = 0; i < moves.length; i++) {
            int index = moves[i] - 1;
            for(int j = 0; j < board.length; j++) {
                int pick = board[j][index];
                if(pick != 0) {
                    if(!picks.isEmpty() && picks.getLast() == pick) {
                        picks.removeLast();
                        answer += 2;
                        board[j][index] = 0;
                        break;
                    } else {
                        picks.addLast(pick);
                        board[j][index] = 0;
                        break;
                    }
                } 
            }
        }

        return answer;
    }

    public int[] hateSameNumber(int []arr) {
        Deque<Integer> distinctNumbers = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if(!distinctNumbers.isEmpty() && distinctNumbers.getLast() == x) {
                continue;
            }

            distinctNumbers.addLast(x);
        }

        List<Integer> result = new ArrayList<>();
        while(!distinctNumbers.isEmpty()) {
            result.add(distinctNumbers.removeFirst());
        }

        return result.stream()
        .mapToInt(Integer::intValue)
        .toArray();
    }
}
