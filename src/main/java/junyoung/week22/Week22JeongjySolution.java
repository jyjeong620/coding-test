package junyoung.week22;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class Week22JeongjySolution {

    public int[] getLottoRanks(int[] lottos, int[] win_nums) {
        Set<Integer> winNumSet = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toSet());
        int zeroCount = 0;
        int winCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            }
            if (winNumSet.contains(lotto)) {
                winCount++;
            }
        }

        int highestRank = getRanking(winCount + zeroCount);
        int lowestRank = getRanking(winCount);

        return new int[]{highestRank, lowestRank};
    }

    public int getRanking(int winCount) {
        return switch (winCount) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }

    public int weaponOfKnight(int number, int limit, int power) {
        int ironWeight = 0;
        for (int i = 1; i <= number; i++) {
            int divisorCount = countDivisor(i);
            ironWeight += divisorCount > limit ? power : divisorCount;

        }
        return ironWeight;
    }

    private int countDivisor(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (i * i != number) {
                    count++;
                }
            }
        }
        return count;
    }

    public String[] secretMap(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i];
            StringBuilder row = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                if ((combined & (1 << j)) != 0) {
                    row.append('#');
                } else {
                    row.append(' ');
                }
            }
            map[i] = row.toString();
        }
        return map;
    }
}
