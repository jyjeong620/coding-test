package yujin.week23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week23Solution {
    public int selectTangerine(int k, int[] tangerine) {
        Map<Integer, Integer> sizeToCount = new HashMap<>();
        for (int size : tangerine) {
            sizeToCount.put(size, sizeToCount.getOrDefault(size, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(sizeToCount.values());
        counts.sort(Collections.reverseOrder());

        int types = 0;
        int total = 0;
        for (int count : counts) {
            total += count;
            types++;
            if (total >= k) {
                return types;
            }
        }

        return types;
    }
}
