package jinwoo.week13;

import java.util.*;

public class Solution {
    public int pocketmon(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;
        Set<Integer> uniquePocketmon = new HashSet<>();
        for(int num : nums) {
            uniquePocketmon.add(num);
        }

        if(max >= uniquePocketmon.size()) {
            answer = uniquePocketmon.size();
        } else {
            answer = max;
        }

        return answer;
    }

    public String year2016(int a, int b) {
        String answer = "";
        int totalDays = 0;

        while (a > 1) {
            a = a - 1;
            if (a == 2) {
                totalDays += 29; // 윤년
            } else if (a == 8 || a == 10 || a == 12) {
                totalDays += 31; // 8, 10, 12월은 짝수지만 31일
            } else if (a == 4 || a == 6 || a == 9 || a == 11) {
                totalDays += 30;
            } else {
                totalDays += 31;
            }
        }
        totalDays += b;

        String[] dayOfTheWeekend = {"FRI", "SAT", "SUN" ,"MON" ,"TUE", "WED", "THU"};
        int next = (totalDays - 1) % 7;
        answer = dayOfTheWeekend[next];

        return answer;
    }

    public String middleChar(String s) {
        String answer = "";
        char[] chars = s.toCharArray();

        int index = s.length() / 2;
        if(s.length() % 2 == 1) {
            char middleChar = chars[index];
            answer = String.valueOf(middleChar);
        } else {
            char[] pariMiddleChar = new char[2];
            pariMiddleChar[0] = chars[index - 1];
            pariMiddleChar[1] = chars[index];
            answer = String.valueOf(pariMiddleChar);
        }

        return answer;
    }
}
