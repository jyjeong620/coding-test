package junyoung.week6;

import java.util.ArrayList;
import java.util.List;

public class Week6JeongjySolution {

    public int[] hallOfFame(int k, int[] score) {
        int[] result = new int[score.length];
        List<Integer> hallOfFame = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            int scoreIndex = score[i];
            if(hallOfFame.size() < k) {
                hallOfFame.add(scoreIndex);
            } else {
                Integer min = hallOfFame.stream().min(Integer::compareTo).get();
                if(min < scoreIndex) {
                    hallOfFame.remove(min);
                    hallOfFame.add(scoreIndex);
                }
            }
            result[i] = hallOfFame.stream().min(Integer::compareTo).get();
        }
        return result;
    }
}
