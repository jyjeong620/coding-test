package hyuntae.week18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @DisplayName("H-Index")
    @ParameterizedTest
    @MethodSource("hIndexTestCases")
    void hIndex(int[] citations, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.hIndex(citations);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] hIndexTestCases() {
        return new Object[][]{
                {new int[]{3, 0, 6, 1, 5}, 3},
                {new int[]{10, 8, 5, 4, 3}, 4},
                {new int[]{25, 8, 5, 3, 3}, 3},
                {new int[]{1, 1, 1}, 1},
                {new int[]{0}, 0}
        };
    }

    @DisplayName("프로세스")
    @ParameterizedTest
    @MethodSource("processTestCases")
    void process(int[] priorities, int location, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.process(priorities, location);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] processTestCases() {
        return new Object[][]{
                {new int[]{2, 1, 3, 2}, 2, 1},
                {new int[]{1, 1, 9, 1, 1, 1}, 0, 5},
                {new int[]{3, 3, 4, 2}, 3, 4},
                {new int[]{5, 5, 5}, 2, 3},
                {new int[]{1}, 0, 1}
        };
    }

    @DisplayName("기능개발")
    @ParameterizedTest
    @MethodSource("featureDevelopmentTestCases")
    void featureDevelopment(int[] progresses, int[] speeds, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.featureDevelopment(progresses, speeds);

        // then
        assertArrayEquals(expected, result);
    }

    private static Object[][] featureDevelopmentTestCases() {
        return new Object[][]{
                {new int[]{93, 30, 55}, new int[]{1, 30, 5}, new int[]{2, 1}},
                {new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 3, 2}},
                {new int[]{100}, new int[]{1}, new int[]{1}},
                {new int[]{50, 50}, new int[]{50, 50}, new int[]{2}},
                {new int[]{20, 40, 60}, new int[]{10, 10, 10}, new int[]{3}}
        };
    }
}