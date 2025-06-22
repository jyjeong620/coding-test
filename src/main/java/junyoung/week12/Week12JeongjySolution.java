package junyoung.week12;

import java.util.Arrays;

public class Week12JeongjySolution {
    public int findPrimeNumber(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int changeToInteger(String s) {
//        return Integer.parseInt(s);  간단한 방법
        boolean sign = true;
        char c = s.charAt(0);
        int result = 0;

        if (c == '-') {
            sign = false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                continue;
            }
            result = result * 10 + (ch - '0');
        }
        return sign ? result : -result;
    }

    public int dartGame(String dartResult) {
        int[] score = new int[3];

        int idx = 0;
        StringBuilder numstr = new StringBuilder();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                numstr.append(c);
            } else if (c == 'S' || c == 'D' || c == 'T') {
                idx = calculateScore(numstr, c, score, idx);
            } else {
                applyOption(c, score, idx);
            }
        }

        return Arrays.stream(score).sum();
    }

    private static void applyOption(char c, int[] score, int idx) {
        if (c == '*') {
            score[idx - 1] *= 2;
            if (idx - 2 >= 0) {
                score[idx - 2] *= 2;
            }
        } else {
            score[idx - 1] *= (-1);
        }
    }

    private int calculateScore(StringBuilder numstr, char c, int[] score, int idx) {
        int num = Integer.parseInt(numstr.toString());
        if (c == 'S') {
            score[idx++] = num;
        } else if (c == 'D') {
            score[idx++] = num * num;
        } else {
            score[idx++] = num * num * num;
        }
        numstr.setLength(0);
        return idx;
    }
}
