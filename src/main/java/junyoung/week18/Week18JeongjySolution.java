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

    public int threeMusketeers(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int magicElevator(int storey){
        int count = 0;
        while (storey > 0) {
            int digit = storey % 10;
            if (digit > 5) {
                count += (10 - digit);
                storey += 10;
            } else if (digit < 5) {
                count += digit;
            } else {
                count += 5;
                if ((storey / 10) % 10 >= 5) {
                    storey += 10;
                }
            }
            storey /= 10;
        }
        return count;
    }
}
