package junyoung.week7;

public class Week7JeongjySolution {
    public String year2016(int a, int b) {
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = b;

        for (int i = 1; i < a; i++) {
            day += month[i];
        }

        return week[day % 7];
    }
}
