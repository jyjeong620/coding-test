package hyuntae.week11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int repaint(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        for (int i = 1; i <= n;) {
            if (i == section[index]) {
                i += m;
                answer++;
                for (int j = index; j < section.length; j++) {
                    if (section[j] >= i) {
                        index = j;
                        break;
                    }
                }
                continue;
            }
            i++;
        }
        return answer;
    }

    public int increaseServer(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < players.length; i++) {
            int player = players[i];
            int need = getServer(player, m);

            while(!q.isEmpty() && q.peek() <= i) {
                q.poll();
            }
            int plus = Math.max(need - q.size(), 0);
            for (int j = 0; j < plus; j++) {
                q.add(i + k);
            }
            result += plus;
        }
        return result;
    }

    private int getServer(int player, int m) {
        return player / m;
    }

    public int parcelBox(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            s.push(i);
            while (!s.isEmpty()) {
                if (s.peek() == order[idx]) {
                    answer++;
                    idx++;
                    s.pop();
                } else break;
            }
        }

        return answer;
    }
}
