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

    public int weaponOfTheKnight(int number, int limit, int power) {
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            int divisorCount = 2;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    divisorCount += 2;
                }
                if (j * j == i) {
                    divisorCount -= 1;
                }
            }
            answer += divisorCount > limit ? power : divisorCount;
        }
        return answer;
    }

    public int cokeProblem(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            answer += n / a * b;
            n = n / a * b + n % a;
        }
        return answer;
    }
}
