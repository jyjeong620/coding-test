package yujin.week7;

import java.util.ArrayList;
import java.util.List;

public class Week7Solution {
    public int plusYinAndYang(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public int[] mockTest(int[] answers) {
        int[] oneRoutine = new int[]{1, 2, 3, 4, 5};
        int[] twoRoutine = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] threeRoutine = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] oneAnswer = new int[answers.length];
        int[] twoAnswer = new int[answers.length];
        int[] threeAnswer = new int[answers.length];

        for (int i = 0; i < answers.length; i++) {
            oneAnswer[i] = oneRoutine[i % oneRoutine.length];
            twoAnswer[i] = twoRoutine[i % twoRoutine.length];
            threeAnswer[i] = threeRoutine[i % threeRoutine.length];
        }

        int[] correctAnswerCounts = new int[3];
        for (int i = 0; i < answers.length; i++) {
            correctAnswerCounts[0] += answers[i] == oneAnswer[i] ? 1 : 0;
            correctAnswerCounts[1] += answers[i] == twoAnswer[i] ? 1 : 0;
            correctAnswerCounts[2] += answers[i] == threeAnswer[i] ? 1 : 0;
        }

        int maxAnswerCount = 0;
        for (int correctAnswerCount : correctAnswerCounts) {
            maxAnswerCount = Math.max(maxAnswerCount, correctAnswerCount);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < correctAnswerCounts.length; i++) {
            if (correctAnswerCounts[i] == maxAnswerCount) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
