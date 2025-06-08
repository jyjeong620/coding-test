package hyuntae.week10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[] iHateSameNumber(int[] arr) {
        int now = -1;
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (now == num) {
                continue;
            }
            now = num;
            list.add(num);
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public int[] reverseNumberToArray(long n) {
        String[] nums = String.valueOf(n).split("");
        return IntStream.range(1, nums.length + 1)
                .map(i -> Integer.parseInt(nums[nums.length - i]))
                .toArray();
    }

    public long integerSquareRootDetermination(long n) {
        long answer = 0;
        for(long i = 1; ; i++) {
            Long account = i * i;
            if(account > n) {
                answer = -1L;
                break;
            } else if (account == n) {
                answer = (i + 1L) * (i + 1L);
                break;
            }
        }
        return answer;
    }
}
