package hyuntae.week18;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = citations.length; i >= 1; i--) {
            if(isValid(citations, i)) return i;
        }

        return 0;
    }

    boolean isValid(int[] citations, int i) {
        int index = citations.length - i;
        return citations[index] >= i;
    }

    public int process(int[] priorities, int location) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        Arrays.sort(priorities);
        int pointer = priorities.length - 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (priorities[pointer] == now[0]) {
                result++;
                pointer--;
                if (location == now[1]) {
                    return result;
                }
            }
            q.offer(now);
        }

        return 0;
    }

    public int[] featureDevelopment(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;

        while(!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progresses[index]) / speeds[index]);
            if(expiration > days) {
                if(days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }

        result.add(count);
        return result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
