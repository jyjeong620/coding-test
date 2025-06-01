package jinwoo.week9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int sumOfMissingDigits(int[] numbers) {
        int answer = 0;
        Set<Integer> num = new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(int a : numbers) {
            num.remove(a);
        }

        for(Integer b: num) {
            answer += b;
        }
        return answer;
    }

    public long calculateShortfall(int price, int money, int count) {
        long answer = 0;
        long totalPay = 0;
        for(int i = 1; i <= count; i++) {
            totalPay += price * i;
        }

        answer = money - totalPay;

        if(answer >= 0) {
            return 0;
        }

        return Math.abs(answer);
    }

    public int[] calculateBestAndWorstLotto(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int commonCount = 0;
        List<Integer> myLotto = List.of(lottos[0], lottos[1], lottos[2], lottos[3], lottos[4], lottos[5]);
        List<Integer> winLotto = List.of(win_nums[0], win_nums[1], win_nums[2], win_nums[3], win_nums[4], win_nums[5]);
        for(int i = 0; i<winLotto.size(); i++) {
            if(myLotto.get(i) == 0) {
                zeroCount += 1;
            }

            Boolean common = myLotto.contains(winLotto.get(i));
            if(common) {
                commonCount += 1;
                continue;
            }
        }

        if(commonCount == 0) {
            if(zeroCount == 6) {
                answer[0] = 1;
                answer[1] = 6;
            } else if(zeroCount == 0) {
                answer[0] = 6;
                answer[1] = 6;
            } else{
                commonCount += 1;
                answer[0] = 7 - (commonCount + zeroCount);
                answer[1] = 7 - commonCount;
            }
        } else {
            answer[0] = 7 - (commonCount + zeroCount);
            answer[1] = 7 - commonCount;
        }

        return answer;
    }


}
