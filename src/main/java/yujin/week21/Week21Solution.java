package yujin.week21;

public class Week21Solution {
    public int partString(String t, String p) {
        int length = p.length();
        Long targetNumber = Long.parseLong(p);
        String[] numbers = t.split("");
        int answer = 0;
        for (int i = 0; i <= t.length() - length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + length; j++) {
                sb.append(numbers[j]);
            }
            if (Long.parseLong(sb.toString()) <= targetNumber) {
                answer++;
            }
        }
        return answer;
    }
}
