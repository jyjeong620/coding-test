package junyoung.week19;

import java.util.HashMap;
import java.util.Map;

public class Week19JeongjySolution {
    public int[] memoryScore(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> nameToYearning = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameToYearning.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                String actual = photo[i][j];
                Integer score = nameToYearning.getOrDefault(actual, 0);
                answer[i] += score;
            }
        }
        return answer;
    }

    public long calculateMoney(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }
        long insufficientAmount = money - totalPrice;
        return insufficientAmount > 0 ? 0 : insufficientAmount * -1;
    }

    public int babbling(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String s : babbling) {
            if (canSpeak(s, words)) {
                count++;
            }
        }
        return count;
    }

    private boolean canSpeak(String str, String[] words) {
        int i = 0;
        String prevWord = "";

        while (i < str.length()) {
            boolean found = false;

            for (String word : words) {
                if (str.startsWith(word, i)) {
                    if (word.equals(prevWord)) {
                        return false;
                    }
                    prevWord = word;
                    i += word.length();
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
