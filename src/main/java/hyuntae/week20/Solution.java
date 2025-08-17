package hyuntae.week20;

public class Solution {
    public double averagePrice(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int data : arr) {
            sum += data;
        }
        answer = (double)sum / arr.length;
        return answer;
    }

    public String evenOdd(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }

    public long perfectSquare(long n) {
        long answer = 0;
        for(long i = 1; ; i++) {
            Long account = i * i;
            if(account > n) {
                answer = -1L;
                break;
            } else if (account == n) {
                answer = (i + 1L) * (i + 1L);
                break;
            }
        }
        return answer;
    }
}
