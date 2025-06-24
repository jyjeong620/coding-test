package yujin.week13;

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
}