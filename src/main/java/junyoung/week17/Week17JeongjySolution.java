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
}
