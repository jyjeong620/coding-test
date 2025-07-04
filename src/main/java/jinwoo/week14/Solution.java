package jinwoo.week14;

import java.util.*;

public class Solution {
    public int dartsGame(String dartResult) {
        int answer = 0;
        String[] darts = dartResult.split("");
        Map<String, Integer> powMap = new HashMap<>();
        powMap.put("S", 1);
        powMap.put("D", 2);
        powMap.put("T", 3);
        Map<String, Integer> bonusMap = new HashMap<>();
        bonusMap.put("*", 2);
        bonusMap.put("#", -1);
        Deque<Integer> numBox = new LinkedList<>();
       
        for(int i = 0; i < darts.length; i++) {
            if(powMap.containsKey(darts[i])) {
                Integer pow = powMap.get(darts[i]);
                Integer num = numBox.removeLast();
                num = (int) Math.pow(num, pow);
                numBox.addLast(num);
            } else if (bonusMap.containsKey(darts[i])){
                Integer bonus = bonusMap.get(darts[i]);
                Integer num = numBox.removeLast();
                if(!numBox.isEmpty() && bonus != -1) {
                    Integer previousNum = numBox.removeLast();
                    previousNum *= bonus;
                    numBox.addLast(previousNum);
                }
                num *= bonus;
                numBox.addLast(num);
            } else {
                if(i != 0 && isInteger(darts[i-1])) {
                    Integer num = numBox.removeLast();
                    num = 10;
                    numBox.addLast(num);
                } else {
                    numBox.addLast(Integer.parseInt(darts[i]));
                }
            } 
        }

        for(Integer num : numBox) {
            answer += num;
        }

        return answer;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String pressKeypad(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, int[]> keypadMap = new HashMap<>();
        keypadMap.put(1, new int[]{0,0});
        keypadMap.put(2, new int[]{0,1});
        keypadMap.put(3, new int[]{0,2});
        keypadMap.put(4, new int[]{1,0});
        keypadMap.put(5, new int[]{1,1});
        keypadMap.put(6, new int[]{1,2});
        keypadMap.put(7, new int[]{2,0});
        keypadMap.put(8, new int[]{2,1});
        keypadMap.put(9, new int[]{2,2});
        keypadMap.put(0, new int[]{3,1});

        int[] startLeft = new int[]{3,0};
        int[] startRight = new int[]{3,2};
        Set<Integer> leftKeys = Set.of(1,4,7);
        Set<Integer> rightKeys = Set.of(3,6,9);

        for(int num : numbers) {
            if(leftKeys.contains(num)) {
                int[] moveKeypad = keypadMap.get(num);
                startLeft = moveKeypad;
                answer += "L";
            } else if(rightKeys.contains(num)) {
                int[] moveKeypad = keypadMap.get(num);
                startRight = moveKeypad;
                answer += "R";
            } else {
                int[] moveKeypad = keypadMap.get(num);
                int leftDistance = calculateDiffDistance(startLeft[0], moveKeypad[0]) + calculateDiffDistance(startLeft[1], moveKeypad[1]);
                int rightDistance = calculateDiffDistance(startRight[0], moveKeypad[0]) + calculateDiffDistance(startRight[1], moveKeypad[1]);

                if(leftDistance < rightDistance) {
                    startLeft = moveKeypad;
                    answer += "L";
                } else if(leftDistance > rightDistance) {
                    startRight = moveKeypad;
                    answer += "R";
                } else {
                    if(hand.equals("left")) {
                        startLeft = moveKeypad;
                        answer += "L";
                    } else {
                        startRight = moveKeypad;
                        answer += "R";
                    }
                }
            }
        }

        return answer;
    }

    private int calculateDiffDistance(int current, int target) {
        int result = Math.abs(current - target);

        return result;
    }

    public int reverseTernary(int n) {
        int answer = 0;
        List<Integer> ternary = new ArrayList<>();

        while(n != 0) {
            int x = n / 3;
            int y = n % 3;
            ternary.add(y);
            n = x;
        }

        Collections.reverse(ternary);

        for(int i = 0; i < ternary.size(); i++) {
            int x = (int) Math.pow(3, i);
            answer += x * ternary.get(i);
        }

        return answer;
    }
}
