package junyoung.week20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Week20JeongjySolution {
    public int rollCakeCutting(int[] topping) {
        int count = 0;

        Map<Integer, Integer> rightCount = new HashMap<>();
        for (int t : topping) {
            rightCount.put(t, rightCount.getOrDefault(t, 0) + 1);
        }

        Set<Integer> leftToppings = new HashSet<>();

        for (int i = 0; i < topping.length - 1; i++) {
            int currentTopping = topping[i];

            leftToppings.add(currentTopping);

            rightCount.put(currentTopping, rightCount.get(currentTopping) - 1);
            if (rightCount.get(currentTopping) == 0) {
                rightCount.remove(currentTopping);
            }

            if (leftToppings.size() == rightCount.size()) {
                count++;
            }
        }

        return count;
    }

    public int divisorCountAndSum(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (countDivisor(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    private int countDivisor(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (i * i != number) {
                    count++;
                }
            }
        }
        return count;
    }

    public int fruitSeller(int k, int m, int[] score) {

        Arrays.sort(score);
        int totalPrice = 0;

        for (int i = score.length - m; i >= 0; i -= m) {
            totalPrice += score[i] * m;
        }

        return totalPrice;

    }
}
