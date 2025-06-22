package hyuntae.week12;

import java.util.*;

public class Solution {
    public int ironDome(int[][] targets) {
        int cur = 0;
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < targets.length; i++) {
            if (cur <= targets[i][0]) {
                cur = targets[i][1];
                answer++;
            }
        }
        return answer;
    }

    private static class Task {
        private final String name;
        private final int start;
        private final int duration;

        Task(String name, int start, int duration) {
            this.name = name;
            this.start = start;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getStart() {
            return start;
        }

        public int calculateEndTime(int from) {
            return from + duration;
        }
    }

    public String[] proceedAssignment(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(plans, (o1, o2) -> toMin(o1[1]) - toMin(o2[1]));
        Stack<Task> stack = new Stack<>();
        int nowTime = toMin(plans[0][1]);

        for (int i = 0; i < plans.length; i++) {
            String[] now = plans[i];
            String nowName = now[0];
            int nowStart = toMin(now[1]);
            int nowDuration = Integer.parseInt(now[2]);

            while (!stack.isEmpty() && nowTime < nowStart) {
                Task task = stack.pop();
                int stackEndTime = task.calculateEndTime(nowTime);

                if (stackEndTime <= nowStart) {
                    answer.add(task.getName());
                    nowTime = stackEndTime;
                } else {
                    stack.push(new Task(task.getName(), task.getStart(), stackEndTime - nowStart));
                    nowTime = nowStart;
                    break;
                }
            }
            stack.push(new Task(nowName, nowStart, nowDuration));
            nowTime = nowStart;
        }

        while (!stack.isEmpty()) {
            Task task = stack.pop();
            answer.add(task.getName());
        }

        return answer.toArray(String[]::new);
    }

    private int toMin(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N, M;
    private static boolean[][] visited;
    private static int[] start;
    private static int[] goal;

    public int ricochetRobot(String[] board) {
        initialize(board);
        return BFS(board);
    }

    private int BFS(String[] board) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            if (goal[0] == x && goal[1] == y) {
                return cnt;
            }
            if (visited[x][y]) {
                continue;
            }
            for (int[] dir: DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (!isMoveable(nextX, nextY, board)) {
                    continue;
                }

                while (true) {
                    if (!isMoveable(nextX, nextY, board)) {
                        q.offer(new int[]{nextX - dir[0], nextY - dir[1], cnt + 1});
                        break;
                    }
                    nextX += dir[0];
                    nextY += dir[1];
                }
                visited[x][y] = true;
            }
        }
        return -1;
    }

    private boolean isMoveable(int x, int y, String[] board) {
        return x >= 0 && y >= 0 && x < N && y < M && board[x].charAt(y) != 'D';
    }

    private void initialize(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[]{i, j};
                }
                if (board[i].charAt(j) == 'G') {
                    goal = new int[]{i, j};
                }
            }
        }
    }
}
