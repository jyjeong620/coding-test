package junyoung.week21;

import java.util.HashMap;
import java.util.Map;

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

    public String nonFinisher(String[] participant, String[] completion) {
        Map<String, Integer> nameToCount = new HashMap<>();
        for (String p : participant) {
            nameToCount.put(p, nameToCount.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            nameToCount.compute(c, (k, v) -> v - 1);
        }
        return nameToCount.entrySet()
                .stream()
                .filter(s -> s.getValue() > 0)
                .findFirst()
                .get()
                .getKey();
    }

    public int discountEvent(String[] want, int[] number, String[] discount) {
        int count = 0;
        Map<String, Integer> wantToNumber = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantToNumber.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> tempWantToNumber = new HashMap<>(wantToNumber);
            for (int j = i; j < i + 10; j++) {
                tempWantToNumber.computeIfPresent(discount[j], (k, v) -> v - 1);
            }
            boolean isShoppingCompleted = tempWantToNumber.entrySet()
                    .stream()
                    .noneMatch(e -> e.getValue() > 0);
            if (isShoppingCompleted) {
                count++;
            }
        }
        return count;
    }
}
