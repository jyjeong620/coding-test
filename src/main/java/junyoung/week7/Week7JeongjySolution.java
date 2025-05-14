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

    public int smallerSubstring(String t, String p) {
        int count = 0;
        int targetLength = p.length();

        for (int i = 0; i <= t.length() - targetLength; i++) {
            int compareResult = t.substring(i, i + targetLength).compareTo(p);
            if (compareResult <= 0) {
                count++;
            }
        }
        return count;
    }

    public String getMiddleString(String s) {
        int length = s.length();
        if (length % 2 == 0) {
            return s.substring(length / 2 - 1, length / 2 + 1);
        }
        return s.substring(length / 2, length / 2 + 1);
    }
}
