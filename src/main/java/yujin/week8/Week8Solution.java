package yujin.week8;

public class Week8Solution {
    public int overPainting(int n, int m, int[] section) {
        int answer = 1;
        int maxPaintSection = section[0] + m - 1;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > maxPaintSection) {
                answer++;
                maxPaintSection = section[i] + m - 1;
            }
        }
        return answer;
    }
}