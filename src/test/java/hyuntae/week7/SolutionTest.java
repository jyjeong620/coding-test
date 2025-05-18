package hyuntae.week7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @DisplayName("내적")
    @ParameterizedTest
    @MethodSource("dotProduct")
    void dotProduct(int[] a, int[] b, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.dotProduct(a, b);

        // then
        assertEquals(expected, result);
    }

    static Object[][] dotProduct() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}, 3},
                {new int[]{-1, 0, 1}, new int[]{1, 0, -1}, -2},
                {new int[]{0, 0, 0}, new int[]{0, 0, 0}, 0},
                {new int[]{1}, new int[]{1}, 1},
                {new int[]{-1}, new int[]{-1}, 1}
        };
    }

    @DisplayName("3진법 뒤집기")
    @ParameterizedTest
    @MethodSource("reverseBase3")
    void reverseBase3(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.reverseBase3(n);

        // then
        assertEquals(expected, result);
    }

    static Object[][] reverseBase3() {
        return new Object[][]{
                {45, 7},
                {125, 229},
                {0, 0},
                {1, 1},
                {2, 2}
        };
    }

    @DisplayName("두 개 뽑아서 더하기")
    @ParameterizedTest
    @MethodSource("reverseTwo")
    void reverseTwo(int[] numbers, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.reverseTwo(numbers);

        // then
        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    static Object[][] reverseTwo() {
        return new Object[][]{
                {new int[]{2, 1, 3, 4, 1}, new int[]{2, 3, 4, 5, 6, 7}},
                {new int[]{5, 0, 2, 7}, new int[]{2, 5, 7, 9, 12}},
                {new int[]{0, 0, 0, 0}, new int[]{0}},
                {new int[]{1, 1, 1, 1}, new int[]{2}},
                {new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6, 7}},
        };
    }
}