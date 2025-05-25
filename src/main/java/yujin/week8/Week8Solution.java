package yujin.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Week8Solution {
    public int overPainting(int n, int m, int[] section) {
        int answer = 1;
        int maxPaintSection = section[0] + m - 1;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > maxPaintSection) {
                answer++;
                maxPaintSection = section[i] + m - 1;
            }
        }
        return answer;
    }

    public int[] failureRate(int n, int[] stages) {
        List<StageFailure> stageFailures = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int stage = i;
            long totalCount = Arrays.stream(stages).filter(num -> num >= stage).count();
            long count = Arrays.stream(stages).filter(num -> num == stage).count();
            double failure = totalCount == 0 ? 0 : 1.0 * count / totalCount;
            stageFailures.add(new StageFailure(stage, failure));
        }

        return stageFailures.stream()
                .sorted(Comparator.comparingDouble(StageFailure::getFailureRate).reversed().thenComparingInt(StageFailure::getStage))
                .mapToInt(StageFailure::getStage)
                .toArray();
    }

    public class StageFailure {
        private final int stage;
        private final double failureRate;

        public StageFailure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        public double getFailureRate() {
            return failureRate;
        }

        public int getStage() {
            return stage;
        }
    }

    public int billFolding(int[] wallet, int[] bill) {
        int answer = 0;
        while (Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1]) || Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1])) {
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }
        return answer;
    }
}