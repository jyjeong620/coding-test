package yujin.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week6Solution {
    public String caesarPassword(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                char password = (char) ((ch - 'a' + n) % 26 + 'a');
                answer.append(password);
            } else if (Character.isUpperCase(ch)) {
                char password = (char) ((ch - 'A' + n) % 26 + 'A');
                answer.append(password);
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    public int budget(int[] d, int budget) {
        int answer = 0;
        int totalD = 0;
        Arrays.sort(d);
        for (int i : d) {
            if (totalD + i > budget) {
                break;
            } else {
                answer++;
                totalD += i;
            }
        }

        return answer;
    }

    public String[] secretMap(int n, int[] arr1, int[] arr2) {
        String format = "%" + n + "s";

        List<String> binaryArr1 = new ArrayList<>(n);
        for (int value : arr1) {
            binaryArr1.add(String.format(format, Integer.toBinaryString(value)).replace(' ', '0'));
        }

        List<String> binaryArr2 = new ArrayList<>(n);
        for (int value : arr2) {
            binaryArr2.add(String.format(format, Integer.toBinaryString(value)).replace(' ', '0'));
        }

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            char[] binary1 = binaryArr1.get(i).toCharArray();
            char[] binary2 = binaryArr2.get(i).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int result = Character.getNumericValue(binary1[j]) + Character.getNumericValue(binary2[j]);
                if (result == 0) {
                    sb.append(" ");
                } else {
                    sb.append('#');
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}