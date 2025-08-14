package yujin.week20;

public class Week20Solution {
    public int[][] arraySum(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public int convertEnglishToNumber(String s) {
        String[] english = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < english.length; i++) {
            if (s.contains(english[i])) {
                s = s.replaceAll(english[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}
