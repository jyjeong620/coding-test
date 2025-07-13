package hyuntae.week15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int findRemainsOne(int n) {
        int answer = 0;
        for(int i = n; i > 0; i--) {
            if(n % i == 1) {
                answer = i;
            }
        }
        return answer;
    }

    private static final char[] CHARS = "AEIOU".toCharArray();

    public int vowelDictionary(String word) {
        List<String> tmp = generate("");
        System.out.println(tmp);
        return tmp.indexOf(word);
    }

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if(word.length() == 5) {
            return words;
        }

        for(char c: CHARS) {
            words.addAll(generate(word + c)); // A AA AE E EA EE
        }

        return words;
    }

    private int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, -1}};
    private int[][] snail;

    public int[] triangleSnail(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        snail = new int[n][];
        for (int i = 0; i < n; i++) {// 초기화
            snail[i] = new int[i+1];
        }

        int dir = 0; //포인터는 계속 ++ 시켜주고 사용할때 /3으로 사용
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            snail[x][y] = cnt;

            int nextX = x + DIRS[dir%3][0];
            int nextY = y + DIRS[dir%3][1];
            if (!isMovable(nextX, nextY)) {
                dir++;
                nextX = x + DIRS[dir%3][0];
                nextY = y + DIRS[dir%3][1];
            }
            if (isMovable(nextX, nextY)) {
                q.offer(new int[]{nextX, nextY, cnt+1});
                continue;
            }
        }
        int cnt = 0;
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail[i].length; j++) {
                answer[cnt++] = snail[i][j];
            }
        }
        return answer;
    }

    private boolean isMovable(int x, int y) {
        return x >= 0 && y >= 0 && snail.length > x && snail[x].length > y && snail[x][y] == 0;
    }
}
