package yujin.week5;

import java.util.PriorityQueue;

public class Solution {
    public int[] hallOfFame(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> topScores = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                topScores.add(score[i]);
                answer[i] = topScores.peek();
            } else {
                int minScore = topScores.peek();
                if (score[i] <= minScore) {
                    answer[i] = minScore;
                } else {
                    topScores.poll();
                    topScores.add(score[i]);
                    answer[i] = topScores.peek();
                }
            }
        }
        return answer;
    }

    public long calculateAmount(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += (long) price * i;
        }
        return money > totalPrice ? 0 : totalPrice - money;
    }

    public int trio(int[] number) {
        int trioCount = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        trioCount++;
                    }
                }
            }
        }
        return trioCount;
    }
}
