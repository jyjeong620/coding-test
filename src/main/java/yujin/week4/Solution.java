package yujin.week4;

public class Solution {
    public String speedEatingCompetition(int[] food) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            builder.append(String.valueOf(i).repeat(food[i] / 2));
        }
        String answer = builder + "0";
        builder.reverse();
        return answer + builder;
    }
}
