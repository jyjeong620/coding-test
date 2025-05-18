package hyuntae.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int dotProduct(int[] a, int[] b) {
        return IntStream.rangeClosed(0, a.length - 1)
                .map(i -> a[i] * b[i])
                .sum();
    }

    public int reverseBase3(int n) {
        String nums = Integer.toString(n, 3);
        String number = new StringBuilder(nums).reverse().toString();
        return Integer.parseInt(number, 3);
    }

    public int[] reverseTwo(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        return list.stream()
                .sorted()
                .distinct()
                .mapToInt(i->i)
                .toArray();
    }
}
