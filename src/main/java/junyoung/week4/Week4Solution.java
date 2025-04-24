package junyoung.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Week4Solution {

    public String findMrKim(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return "김서방은 없다";
    }

    public int[] mockExam(int[] answers) {
        int[] mathHater1 = new int[]{1, 2, 3, 4, 5};
        int[] mathHater2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] mathHater3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answerCount1 = grade(answers, mathHater1);
        int answerCount2 = grade(answers, mathHater2);
        int answerCount3 = grade(answers, mathHater3);

        return findMaxIndices(answerCount1, answerCount2, answerCount3);
    }

    private int grade(int[] answers, int[] mathHater1) {
        int length = mathHater1.length;
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mathHater1[i % length]) {
                count++;
            }
        }
        return count;
    }

    private int[] findMaxIndices(int a, int b, int c) {
        int[] arr = {a, b, c};
        int max = Math.max(Math.max(a, b), c);

        int count = 0;
        for (int num : arr) {
            if (num == max) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                result[index++] = i + 1; // 1부터 시작하는 인덱스로 변환
            }
        }

        return result;
    }

    // timeout 발생
    public String findFriend(String X, String Y) {
        List<String> splitX = Arrays.stream(X.split("")).toList();
        List<String> splitY = Arrays.stream(Y.split("")).collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        splitX.stream()
                .filter(splitY::contains)
                .forEach(x -> {
                    result.add(x);
                    splitY.remove(x);
                });
        if (result.isEmpty()) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        result.stream()
                .sorted(Comparator.comparing(Integer::parseInt, Comparator.reverseOrder()))
                .forEach(sb::append);
        int i = Integer.parseInt(sb.toString());

        return String.valueOf(i);
    }

    public String refactorFindFriend(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        boolean hasCommon = false;

        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(countX[i], countY[i]);
            if (commonCount > 0) {
                hasCommon = true;
                for (int j = 0; j < commonCount; j++) {
                    sb.append(i);
                }
            }
        }

        if (!hasCommon) {
            return "-1";
        }

        String result = sb.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}
