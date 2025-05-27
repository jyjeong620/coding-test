package junyoung.week9;

import java.util.ArrayList;
import java.util.List;

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
}
