package yujin.week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week13Solution {
    public int dartGame(String dartResult) {
        String[] rounds = new String[3];
        int roundIndex = 0;
        StringBuilder currentRound = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            char value = dartResult.charAt(i);
            currentRound.append(value);
            if (value == 'S' || value == 'D' || value == 'T') {
                if (i + 1 < dartResult.length()) {
                    char nextValue = dartResult.charAt(i + 1);
                    if (nextValue == '*' || nextValue == '#') {
                        currentRound.append(nextValue);
                        i++;
                    }
                }
                rounds[roundIndex++] = currentRound.toString();
                currentRound = new StringBuilder();
            }
        }

        int[] roundScores = new int[3];

        for (int i = 0; i < 3; i++) {
            String[] roundScore = rounds[i].split("");
            int roundScoreIndex = 0;
            int score = 0;
            if (roundScore[0].equals("1") && roundScore[1].equals("0")) {
                score = 10;
                roundScoreIndex = 2;
            } else {
                score = Integer.parseInt(roundScore[0]);
                roundScoreIndex = 1;
            }
            String bonus = roundScore[roundScoreIndex++];
            String option = roundScoreIndex < roundScore.length ? roundScore[roundScoreIndex] : "";

            roundScores[i] = bonus.equals("S") ? score : bonus.equals("D") ? score * score : score * score * score;
            roundScores[i] = option.equals("#") ? roundScores[i] * -1 : option.equals("*") ? roundScores[i] * 2 : roundScores[i];
            if (i != 0 && option.equals("*")) {
                roundScores[i - 1] *= 2;
            }
        }

        return roundScores[0] + roundScores[1] + roundScores[2];
    }

    public int workoutClothes(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> actualLost = new ArrayList<>();
        for(int lostStudent : lost) {
            boolean actual = true;
            for(int reserveStudent : reserve) {
                if (lostStudent == reserveStudent) {
                    actual = false;
                    break;
                }
            }
            if (actual) {
                actualLost.add(lostStudent);
            }
        }

        List<Integer> actualReserve = new ArrayList<>();
        for(int reserveStudent : reserve) {
            boolean actual = true;
            for(int lostStudent : lost) {
                if (reserveStudent == lostStudent) {
                    actual = false;
                    break;
                }
            }
            if (actual) {
                actualReserve.add(reserveStudent);
            }
        }

        int answer = n - actualLost.size();
        for(int reserveStudent : actualReserve) {
            for (int i = 0; i < actualLost.size(); i ++) {
                int lostStudent = actualLost.get(i);
                if (lostStudent == reserveStudent - 1 || lostStudent == reserveStudent + 1) {
                    answer++;
                    actualLost.remove(i);
                    break;
                }
            }
        }

        return answer;
    }
}