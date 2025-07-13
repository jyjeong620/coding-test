package jinwoo.week15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution = new Solution();
    
    @DisplayName("[1차] 비밀 지도")
    @Test
    void testSecretMap() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] expected = {
            "#####",
            "# # #",
            "### #",
            "#  ##",
            "#####"
        };

        assertArrayEquals(expected, solution.secretMap(n, arr1, arr2));
    }

    @DisplayName("크레인 인형뽑기 게임")
    @Test
    void testCraneDollGame() {
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int expected = 4;
        int result = solution.craneDollGame(board, moves);

        assertEquals(expected, result);
    }

    @DisplayName("같은 숫자는 싫어")
    @Test
    void testHateSameNumber() {
        int[] input = {1, 1, 3, 3, 0, 1, 1};
        int[] expected = {1, 3, 0, 1};

        assertArrayEquals(expected, solution.hateSameNumber(input));
    }
}
