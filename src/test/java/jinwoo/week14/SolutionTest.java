package jinwoo.week14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution = new Solution();
    
    @DisplayName("[1차] 다트 게임")
    @Test
    void testDartsGame() {
        // given
        String input = "1S2D*3T";

        // when
        int result = solution.dartsGame(input);

        // then
        assertEquals(37, result);
    }

    @DisplayName("키패드 누기")
    @Test
    void testPressKeypad() {
        // given
        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        // when
        String result = solution.pressKeypad(numbers, hand);

        // then
        assertEquals("LRLLLRLLRRL", result);
    }

    @DisplayName("3진법 뒤집기")
    @Test
    void testReverseTernary() {
        int result = solution.reverseTernary(45);
        assertEquals(7, result);
    }
}
