package junyoung.week20;

import java.util.*;

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
}
