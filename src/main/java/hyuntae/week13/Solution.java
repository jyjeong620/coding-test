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
        int picksCount = (int) Arrays.stream(picks)
                .sum() * 5;
        return Math.min(picksCount, mineralCount);
    }
}
