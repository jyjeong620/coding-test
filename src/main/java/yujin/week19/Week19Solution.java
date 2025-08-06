package yujin.week19;

import java.util.HashMap;
import java.util.Map;

public class Week19Solution {
    public String[] runningRace(String[] players, String[] callings) {
        Map<String, Integer> playerToRank = new HashMap<>();
        Map<Integer, String> rankToPlayer = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerToRank.put(players[i], i);
            rankToPlayer.put(i, players[i]);
        }

        for (String callingPlayer : callings) {
            int originRank = playerToRank.get(callingPlayer);
            int newRank = originRank - 1;
            String loserPlayer = rankToPlayer.get(newRank);
            playerToRank.put(callingPlayer, newRank);
            playerToRank.put(loserPlayer, originRank);
            rankToPlayer.put(originRank, loserPlayer);
            rankToPlayer.put(newRank, callingPlayer);
        }

        return rankToPlayer.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toArray(String[]::new);
    }
}
