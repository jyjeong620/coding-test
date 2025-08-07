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

    public int[] walkPark(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] parkMap = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            char[] p = park[i].toCharArray();
            for (int j = 0; j < park[i].length(); j++) {
                parkMap[i][j] = p[j];
                if (p[j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (String route : routes) {
            String[] r = route.split(" ");
            int move = Integer.parseInt(r[1]);
            boolean meetX = false;
            if (r[0].equals("N")) {
                if (answer[0] - move >= 0) {
                    for (int i = 1; i <= move; i++) {
                        if (parkMap[answer[0] - i][answer[1]] == 'X') {
                            meetX = true;
                        }
                    }
                    if (!meetX) {
                        answer[0] = answer[0] - move;
                    }
                }
            }

            if (r[0].equals("S")) {
                if (answer[0] + move < parkMap.length) {
                    for (int i = 1; i <= move; i++) {
                        if (parkMap[answer[0] + i][answer[1]] == 'X') {
                            meetX = true;
                        }
                    }
                    if (!meetX) {
                        answer[0] = answer[0] + move;
                    }
                }
            }

            if (r[0].equals("W")) {
                if (answer[1] - move >= 0) {
                    for (int i = 1; i <= move; i++) {
                        if (parkMap[answer[0]][answer[1] - i] == 'X') {
                            meetX = true;
                        }
                    }
                    if (!meetX) {
                        answer[1] = answer[1] - move;
                    }
                }
            }

            if (r[0].equals("E")) {
                if (answer[1] + move < parkMap[0].length) {
                    for (int i = 1; i <= move; i++) {
                        if (parkMap[answer[0]][answer[1] + i] == 'X') {
                            meetX = true;
                        }
                    }
                    if (!meetX) {
                        answer[1] = answer[1] + move;
                    }
                }
            }
        }

        return answer;
    }
}
