package junyoung.week21;

public class Week21JeongjySolution {

    public int splitString(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;

        char x = 0;

        for (char c : s.toCharArray()) {
            if (sameCount == 0) {
                x = c;
            }
            if (c == x) {
                sameCount++;
            } else {
                diffCount++;
            }
            if (sameCount == diffCount) {
                answer++;
                sameCount = 0;
                diffCount = 0;
            }
        }
        if (sameCount != 0) {
            answer++;
        }
        return answer;
    }
}
