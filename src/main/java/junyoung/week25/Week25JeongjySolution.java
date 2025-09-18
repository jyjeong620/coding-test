package junyoung.week25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week25JeongjySolution {

    public boolean phoneNumber(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public int[] englishRelay(int n, String[] words) {
        int currentWordIndex = 0;
        Set<String> usedWords = new HashSet<>();

        while (currentWordIndex < words.length) {
            String currentWord = words[currentWordIndex];

            int currentPlayer = currentWordIndex % n + 1;
            int currentRound = currentWordIndex / n + 1;

            if (usedWords.contains(currentWord)) {
                return new int[]{currentPlayer, currentRound};
            }

            if (currentWordIndex > 0) {
                String previousWord = words[currentWordIndex - 1];
                char lastChar = previousWord.charAt(previousWord.length() - 1);
                char firstChar = currentWord.charAt(0);

                if (lastChar != firstChar) {
                    return new int[]{currentPlayer, currentRound};
                }
            }

            usedWords.add(currentWord);
            currentWordIndex++;
        }

        return new int[]{0, 0};
    }
}
