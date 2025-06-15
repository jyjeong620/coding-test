package jinwoo.week11;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int workoutClothes(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int originPossibleMember = n - lost.length;
        answer += originPossibleMember;

        HashSet<Integer> reserveSetMember = new HashSet<>();
        List<Integer> uniqueLostMember = new ArrayList<>();
        for(int lostMem: lost) {
            uniqueLostMember.add(lostMem);
        }
        for(int reserveMem: reserve) {
            reserveSetMember.add(reserveMem);
        }

        for(int i=0; i<lost.length; i++) {
            int lostMember = lost[i];
            if(reserveSetMember.contains(lostMember)) {
                answer++;
                reserveSetMember.remove(lostMember);
                int index = uniqueLostMember.indexOf(lostMember);
                uniqueLostMember.remove(index);
            }
        }

        List<Integer> orderUniqueLostMember = uniqueLostMember.stream()
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());

        for(Integer lostMem : orderUniqueLostMember) {
            if(reserveSetMember.contains(lostMem - 1)) {
                answer++;
                reserveSetMember.remove(lostMem-1);
                continue;
            }

            if(reserveSetMember.contains(lostMem+1)) {
                answer++;
                reserveSetMember.remove(lostMem+1);
                continue;
            }
        }

        return answer;
    }

    public int[] mockTest(int[] answers) {
        int[] answer = {};
        List<Integer> num1 = new ArrayList<>(List.of(1,2,3,4,5));
        List<Integer> num2 = new ArrayList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        List<Integer> num3 = new ArrayList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        int num1CollectCount = 0;
        int num2CollectCount = 0;
        int num3CollectCount = 0;

        for(int i = 0; i < answers.length; i++) {
            int num1Index = i%5;
            int num2Index = i%8;
            int num3Index = i%10;
            if(num1.get(num1Index) == answers[i]) {
                num1CollectCount++;
            }
            if(num2.get(num2Index) == answers[i]) {
                num2CollectCount++;
            }
            if(num3.get(num3Index) == answers[i]) {
                num3CollectCount++;
            }
        }
        List<Integer> numList = new ArrayList<>(List.of(num1CollectCount, num2CollectCount, num3CollectCount));
        Integer maxNum = Collections.max(numList);

        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(1, num1CollectCount);
        numMap.put(2, num2CollectCount);
        numMap.put(3, num3CollectCount);

        answer = numMap.entrySet().stream()
        .filter(it -> it.getValue() >= maxNum)
        .mapToInt(it -> it.getKey())
        .sorted()
        .toArray();

        return answer;
    }

    public int sumWithSigns(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
