package junyoung.week14;

import java.util.Arrays;
import java.util.Comparator;

public class Week14JeongjySolution {
    public int physicalEducationKit(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((k - 1 == reserve[j]) || (k + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public long sortNumberDesc(long n) {
        String[] splitNumber = String.valueOf(n).split("");
        Arrays.sort(splitNumber, Comparator.reverseOrder());

        return Long.parseLong(String.join("", splitNumber));
    }

    public boolean isHarshadNumber(int x) {
        int originalNumber = x;
        int digitSum = 0;

        while (x > 0) {
            digitSum += x % 10;
            x /= 10;
        }

        return originalNumber % digitSum == 0;
    }
}
