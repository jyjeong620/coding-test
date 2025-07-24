package junyoung.week17;

import java.util.HashMap;
import java.util.Map;

public class Week17JeongjySolution {
    public String[] running(String[] players, String[] callings) {
        Map<String, Integer> playerToRanking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerToRanking.put(players[i], i);
        }

        for (String calling : callings) {
            int ranking = playerToRanking.get(calling);

            String frontPlayer = players[ranking - 1];

            players[ranking - 1] = calling;
            players[ranking] = frontPlayer;

            playerToRanking.put(calling, ranking - 1);
            playerToRanking.put(frontPlayer, ranking);
        }
        return players;
    }

    public int[] smallestNumberRemove(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int[] result = new int[arr.length - 1];
        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) {
                result[resultIndex++] = arr[i];
            }
        }

        return result;
    }
}
