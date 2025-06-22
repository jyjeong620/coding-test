package hyuntae.week13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @DisplayName("광물 캐기")
    @ParameterizedTest
    @MethodSource("miningTestCases")
    void mining(int[] picks, String[] minerals, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.mining(picks, minerals);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] miningTestCases() {
        return new Object[][]{
            {new int[]{1, 1, 1}, new String[]{"diamond", "diamond", "diamond", "iron", "stone", "stone", "stone"}, 7},
            {new int[]{2, 0, 0}, new String[]{"diamond", "iron", "stone", "stone", "stone"}, 5},
            {new int[]{0, 2, 1}, new String[]{"diamond", "diamond", "iron", "stone"}, 12},
            {new int[]{0, 0, 3}, new String[]{"stone", "stone", "stone"}, 3},
            {new int[]{1, 2, 3}, new String[]{"diamond", "iron", "stone"}, 3}
        };
    }
}