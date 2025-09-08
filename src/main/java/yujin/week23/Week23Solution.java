package yujin.week23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public int savePeople(int[] people, int limit) {
        Arrays.sort(people);
        int leftIndex = 0;
        int rightIndex = people.length - 1;

        int count = 0;
        while (leftIndex <= rightIndex) {
            if (people[leftIndex] + people[rightIndex] <= limit) {
                leftIndex++;
            }
            rightIndex--;
            count++;
        }

        return count;
    }

    public int[] englishRelay(int n, String[] words) {
        Set<String> already = new HashSet<>();
        int wrongIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (already.contains(words[i])) {
                wrongIndex = i;
                break;
            } else {
                already.add(words[i]);
            }

            if (i > 0) {
                if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    wrongIndex = i;
                    break;
                }
            }
        }

        return wrongIndex == 0 ? new int[]{0, 0} : new int[]{wrongIndex % n + 1, wrongIndex / n + 1};
    }
}
