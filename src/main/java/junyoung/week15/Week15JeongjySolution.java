package junyoung.week15;

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
}
