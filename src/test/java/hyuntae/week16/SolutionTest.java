package hyuntae.week16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @DisplayName("수식 최대화")
    @ParameterizedTest
    @MethodSource("expressionMaximizationTestCases")
    void expressionMaximization(String expression, long expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.expressionMaximization(expression);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] expressionMaximizationTestCases() {
        return new Object[][]{
                {"100-200*300-500+20", 60420},
        };
    }

    @DisplayName("스킬트리")
    @ParameterizedTest
    @MethodSource("skillTreeTestCases")
    void skillTree(String skill, String[] skill_trees, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.skillTree(skill, skill_trees);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] skillTreeTestCases() {
        return new Object[][]{
                {"CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}, 2},
                {"ABC", new String[]{"AB", "AC", "BC"}, 1},
                {"XYZ", new String[]{"XZY", "YZX", "ZXY"}, 0},
        };
    }

    @DisplayName("타겟 넘버")
    @ParameterizedTest
    @MethodSource("targetNumberTestCases")
    void targetNumber(int[] numbers, int target, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.targetNumber(numbers, target);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] targetNumberTestCases() {
        return new Object[][]{
                {new int[]{1, 1, 1, 1, 1}, 3, 5},
                {new int[]{4, 1, 2, 1}, 4, 2},
                {new int[]{0, 0, 0}, 0, 8},
                {new int[]{1}, 1, 1},
        };
    }
}