package junyoung.week12;

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
}
