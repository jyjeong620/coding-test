package junyoung.week18;

public class Week18JeongjySolution {
    public int[] GCDAndLCM(int n, int m) {
        int gcd = calculateGCD(n, m);
        int lcm = (n * m) / gcd;
        return new int[]{gcd, lcm};
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
