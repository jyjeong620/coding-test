package junyoung.week9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Week9JeongjySolution {
    public int[] divide(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        return list.stream()
                .sorted()
                .mapToInt(i -> i).toArray();
    }

    public int phonekemon(int[] nums) {
        Set<Integer> phonekemon = new HashSet<>();
        for (int num : nums) {
            phonekemon.add(num);
            if (phonekemon.size() == nums.length / 2) {
                break;
            }
        }
        return phonekemon.size();
    }

    public long sumNumbers(int a, int b) {
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a,b))
                .sum();
    }
}
