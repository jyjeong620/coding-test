package junyoung.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Week6JeongjySolution {

    public int[] hallOfFame(int k, int[] score) {
        int[] result = new int[score.length];
        List<Integer> hallOfFame = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int scoreIndex = score[i];
            if (hallOfFame.size() < k) {
                hallOfFame.add(scoreIndex);
            } else {
                Integer min = hallOfFame.stream().min(Integer::compareTo).get();
                if (min < scoreIndex) {
                    hallOfFame.remove(min);
                    hallOfFame.add(scoreIndex);
                }
            }
            result[i] = hallOfFame.stream().min(Integer::compareTo).get();
        }
        return result;
    }

    public int[] refactorHallOfFame(int k, int[] score) {
        int[] result = new int[score.length];
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            int currentScore = score[i];

            if (hallOfFame.size() < k) {
                hallOfFame.offer(currentScore);
            } else if (!hallOfFame.isEmpty() && hallOfFame.peek() < currentScore) {
                hallOfFame.poll();
                hallOfFame.offer(currentScore);
            }

            result[i] = hallOfFame.isEmpty() ? 0 : hallOfFame.peek();
        }

        return result;
    }

    public int cola(int a, int b, int n) {
        int answer = 0;
        int leftoverBottle = 0;

        while (n + leftoverBottle >= a) {
            int emptyBottle = (n + leftoverBottle) / a * b;
            leftoverBottle = (n + leftoverBottle) % a;
            answer += emptyBottle;
            n = emptyBottle;
        }

        return answer;
    }

    public String clapOrWaterMelon(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n)
                .forEach(i -> sb.append(i % 2 == 0 ? "수" : "박"));
        return sb.toString();
    }
}
