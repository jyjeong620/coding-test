package jinwoo.week10;

import java.util.*;

public class Solution {
    public int sumWithDivisorCountRule(int left, int right) {
        int answer = 0;
        for(int i = left; i <=right; i++) {
            int count = 0;
            for(int j = 1; j <= i; j++) {
                if(i%j == 0) {
                    count++;
                }
            }
            
            if(count%2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public int[] sumTwoPickedNumbers(int[] numbers) {
        int[] answer = {};
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                numSet.add(numbers[i] + numbers[j]);
            }
        }

        answer = numSet.stream()
        .sorted()
        .mapToInt(Integer::intValue)
        .toArray();
        
        return answer;
    }

    public int[] getFailureRate(int N, int[] stages) {
        int[] answer = {};

        //stage, count
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            countMap.put(i,0);
        }

        for(int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            if(stage > N) {
                continue;
            }

            countMap.put(stage, countMap.get(stage) + 1);
        }

        //stage, failRate
        Map<Integer, Double> failRateMap = new HashMap<>();

        int totalNum = stages.length;
        for(int i = 1; i <= N; i++) {
            if(totalNum == 0) {
                failRateMap.put(i, 0.0);
                continue;
            }
            int stageCount = countMap.get(i);
            double failRate = (double) stageCount / totalNum;
            failRateMap.put(i, failRate);
            totalNum -= stageCount;
        }

        answer = failRateMap.entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry<Integer, Double>::getValue, Comparator.reverseOrder())
        .thenComparing(Map.Entry::getKey)
        )
        .mapToInt(Map.Entry::getKey)
        .toArray();

        return answer;
    }

}
