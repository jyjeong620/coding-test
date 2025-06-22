package hyuntae.week13;

import java.util.*;

public class Solution {
    private static final int[][] RATE = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    private static class MineralGroup {
        private final int diamond;
        private final int iron;
        private final int stone;

        public MineralGroup(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        public int getWeight() {
            return diamond * 25 + iron * 5 + stone; // 가중치 계산
        }

        public int calculateTired(int pick) {
            if (pick == 0) {
                return diamond + iron + stone;
            }
            if (pick == 1) {
                return diamond * 5 + iron + stone;
            }
            if (pick == 2) {
                return diamond * 25 + iron * 5 + stone;
            }
            return 0;
        }
    }

    public int mining(int[] picks, String[] minerals) {
        int answer = 0;
        int maxCount = calculateMaxDigging(picks, minerals.length);
        minerals = Arrays.copyOfRange(minerals, 0, maxCount);
        List<MineralGroup> mineralGroups = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                String mineral = minerals[j];
                if ("diamond".equals(mineral)) {
                    diamond++;
                }
                if ("iron".equals(mineral)) {
                    iron++;
                }
                if ("stone".equals(mineral)) {
                    stone++;
                }
            }
            mineralGroups.add(new MineralGroup(diamond, iron, stone));
        }
        Collections.sort(mineralGroups, Comparator.comparingInt(MineralGroup::getWeight).reversed());
        int groupCount = 0;
        for (int i = 0; i < picks.length; i++) {
            for (int j = 1; j <= picks[i] && groupCount < mineralGroups.size(); j++) {
                MineralGroup group = mineralGroups.get(groupCount);
                answer += group.calculateTired(i);
                groupCount++;
            }
        }
        return answer;
    }

    public int calculateMaxDigging(int[] picks, int mineralCount) {
        int picksCount = Arrays.stream(picks)
                .sum() * 5;
        return Math.min(picksCount, mineralCount);
    }

    private final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int N, M;
    private boolean[][] visited;
    private int[] lever, start, end;

    public int escapeMaze(String[] maps) {
        initialize(maps);
        return BFS(maps);
    }

    private int BFS(String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        boolean isExitable = false;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (!isExitable && x == lever[0] && y == lever[1]) {
                System.out.println(cnt);
                isExitable = true;
                q.clear(); //도착하면 가장 빠른 방법이므로 queue 정리
                visited = new boolean[N][M]; //방문 기록 초기화 후 이전 위치도 갈 수 있도록
            }
            if (isExitable && x == end[0] && y == end[1]) {
                System.out.println(cnt);
                return cnt;
            }
            for (int[] dir: DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (isMoveable(nextX, nextY, maps)) {
                    q.offer(new int[]{nextX, nextY, cnt + 1});
                }
            }
        }
        return -1;
    }

    private boolean isMoveable(int x, int y, String[] maps) {
        return x >= 0 && y >= 0 && x < N && y < M && maps[x].charAt(y) != 'X';
    }

    private void initialize(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
                if (maps[i].charAt(j) == 'E') {
                    end = new int[]{i, j};
                }
                if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
    }
}
