package hyuntae.week14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.BiFunction;

public class Solution {
    public int[] findNextGreaterElement(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> s = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            int number = numbers[i];
            answer[i] = -1;
            while (!s.isEmpty()) {
                int top = s.peek();
                if (top > number) {
                    answer[i] = top;
                    break;
                }
                s.pop();
            }
            s.add(number);
        }
        return answer;
    }

    public int transferNumber(int x, int y, int n) {
        return BFS(x, y, n);
    }

    private int BFS(int x, int y, int n) {
        boolean[] visited = new boolean[y * 3 + 1];// bfs 에서 최대 나올 수 있는 숫자
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (visited[now[0]]) {
                continue;
            }
            visited[now[0]] = true;
            if (now[0] == y) {
                return now[1];
            }
            if (now[0] > y) {
                continue;
            }
            for (BiFunction<Integer, Integer, Integer> function : functions) {
                int next = function.apply(now[0], n);
                if (next <= y) {
                    q.offer(new int[]{next, now[1]+1});
                }
            }
        }
        return -1;
    }

    private static final BiFunction<Integer, Integer, Integer>[] functions = new BiFunction[]{
            (a, b) -> (int) a * 2,
            (a, b) -> (int) a * 3,
            (a, b) -> (int) a + (int) b,
    };
}
