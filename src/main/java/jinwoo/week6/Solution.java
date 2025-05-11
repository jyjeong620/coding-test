package jinwoo.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.*;

public class Solution {
    public String foodFightContest(int[] food) {
        String answer;
        List<Integer> foodList = new ArrayList<>();

        for (int i = 1; i < food.length; i++) {
            int num = food[i] / 2;

            if (num == 0) {
                continue;
            }
            for (int j = 1; j <= num; j++) {
                foodList.add(i);
            }
        }
        List<Integer> reverseFoodList = foodList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        foodList.add(0);
        foodList.addAll(reverseFoodList);

        answer = foodList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return answer;
    }

    public int makeBurger(int[] ingredient) {
        int answer = 0;
        Stack<Integer> making = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            making.push(ingredient[i]);

            if (making.size() >= 4) {
                if (making.get(making.size()-1) == 1 && making.get(making.size()-2) == 3 && making.get(making.size()-3) == 2 && making.get(making.size()-4) == 1) {
                    making.pop();
                    making.pop();
                    making.pop();
                    making.pop();
                    answer++;
                }
            }
        }
        return answer;
    }

    public int babbling(String[] babbling) {
        int answer = 0;

        for(int i = 0; i < babbling.length; i++) {
            String babb = babbling[i];
            babb = babb.replaceAll("aya", "A");
            babb = babb.replaceAll("ye", "B");
            babb = babb.replaceAll("woo", "C");
            babb = babb.replaceAll("ma", "D");

            if(babb.contains("AA") || babb.contains("BB") || babb.contains("CC") || babb.contains("DD")) {
                continue;
            }

            babb = babb.replaceAll("A", "");
            babb = babb.replaceAll("B", "");
            babb = babb.replaceAll("C", "");
            babb = babb.replaceAll("D", "");

            if(babb.isBlank()) {
                answer++;
            }
        }

        return answer;
    }
}
