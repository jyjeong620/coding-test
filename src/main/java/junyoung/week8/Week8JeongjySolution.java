package junyoung.week8;

import java.util.HashMap;
import java.util.Map;

public class Week8JeongjySolution {
    public int[] keyboard(String[] keymaps, String[] targets) {
        int[] answer = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            String target = targets[j];
            int totalIndexCount = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int lowestIndex = getLowestIndex(keymaps, c);
                if (lowestIndex == -1) {
                    totalIndexCount = -1;
                    break;
                }
                totalIndexCount += lowestIndex;
            }
            answer[j] = totalIndexCount;
        }

        return answer;
    }

    private int getLowestIndex(String[] keymaps, char c) {
        int index = 100;
        for (String keymap : keymaps) {
            int tempIndex = keymap.indexOf(c);
            if (tempIndex != -1 && index > tempIndex) {
                index = tempIndex;
            }
        }
        if (index == 100) {
            return -1;
        }
        return index + 1;
    }

    public int[] keyboard2(String[] keymaps, String[] targets) {
        // 각 문자에 대한 최소 인덱스를 미리 계산
        Map<Character, Integer> minIndices = new HashMap<>();
        for (String keymap : keymaps) {
            for (int i = 0; i < keymap.length(); i++) {
                char c = keymap.charAt(i);
                minIndices.merge(c, i + 1, Math::min);
            }
        }

        int[] answer = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            String target = targets[j];
            int totalKeystrokes = 0;
            boolean allCharsFound = true;

            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                Integer keystrokes = minIndices.get(c);

                if (keystrokes == null) {
                    allCharsFound = false;
                    break;
                }

                totalKeystrokes += keystrokes;
            }

            answer[j] = allCharsFound ? totalKeystrokes : -1;
        }

        return answer;
    }
}
