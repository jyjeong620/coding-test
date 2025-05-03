package jinwoo.week5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] theHallOfFrame(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> hallOfFrame = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            hallOfFrame.add(score[i]);
            hallOfFrame.sort(Collections.reverseOrder());
            if(hallOfFrame.size() > k) {
                hallOfFrame.remove(hallOfFrame.size() - 1);
            }

            answer[i] = hallOfFrame.get(hallOfFrame.size()-1);
        }

        return answer;
    }

    public int knightsWeapon(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    if (j != i / j) {
                        count++;
                    }
                }
            }

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }

    public int fruitSeller(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> reverseScore =  new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            reverseScore.add(score[i]);
        }
        reverseScore.sort(Collections.reverseOrder());
        if(m > score.length) {
            return 0;
        }

        for (int i = 0; i + m <= reverseScore.size(); i += m) {
            List<Integer> box = reverseScore.subList(i, i + m);
            int minScore = box.get(m - 1);
            answer += minScore * m;
        }

        return answer;
    }
}
