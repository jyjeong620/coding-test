package junyoung.week15;

import java.util.Arrays;

public class Week15JeongjySolution {
    public long getNextSquareOrMinusOne(long n) {
        long sqrt = (long) Math.sqrt(n);

        for (long i = Math.max(1, sqrt - 1); i <= sqrt + 1; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1);
            }
        }
        return -1L;
    }

    public int overpainting(int n, int m, int[] section) {
        Arrays.sort(section);

        int answer = 0;
        int lastPainted = 0;

        for (int s : section) {
            if (s > lastPainted) {
                lastPainted = s + m - 1;
                answer++;
            }
        }
        return answer;
    }

    public int remainderOne(int n) {
        int answer = 2;
        while (n % answer != 1) {
            answer++;
        }
        return answer;
    }
}
