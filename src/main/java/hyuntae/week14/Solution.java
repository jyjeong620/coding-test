package hyuntae.week14;

import java.util.*;
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

    public long seesaw(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        return answer;
    }

    private final List<Integer> answer = new ArrayList<>();
    private static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int M, N;

    public int[] uninhabitedIslandTrip(String[] maps) {
        M = maps.length;
        N = maps[0].length();
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answer.add(BFS(maps, i, j));
                }
            }
        }
        if (answer.size() == 0) {
            return new int[]{-1};
        }
        return answer.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }

    private int BFS(String[] maps, int startX, int startY) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            int num = maps[x].charAt(y) - '0';
            answer += num;
            for (int[] dir : DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (isMoveable(maps, nextX, nextY)) {
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }

        return answer;
    }

    private boolean isMoveable(String[] maps, int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N && maps[x].charAt(y) != 'X';
    }
}
