package hyuntae.week20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @DisplayName("평균 가격")
    @ParameterizedTest
    @MethodSource("averagePriceTestCases")
    void averagePrice(int[] arr, double expected) {
        // given
        Solution solution = new Solution();

        // when
        double result = solution.averagePrice(arr);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] averagePriceTestCases() {
        return new Object[][]{
                {new int[]{100, 200, 300}, 200.0},
                {new int[]{50, 150, 250}, 150.0},
                {new int[]{10, 20, 30, 40}, 25.0},
                {new int[]{5}, 5.0},
                {new int[]{1, 2, 3, 4, 5}, 3.0}
        };
    }

    @DisplayName("짝수 홀수 판별")
    @ParameterizedTest
    @MethodSource("evenOddTestCases")
    void evenOdd(int num, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.evenOdd(num);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] evenOddTestCases() {
        return new Object[][]{
                {2, "Even"},
                {3, "Odd"},
                {0, "Even"},
                {-1, "Odd"},
                {-2, "Even"}
        };
    }

    @DisplayName("완전 제곱수 판별")
    @ParameterizedTest
    @MethodSource("perfectSquareTestCases")
    void perfectSquare(long n, long expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.perfectSquare(n);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] perfectSquareTestCases() {
        return new Object[][]{
                {16, 25},
                {25, 36},
                {10, -1},
                {1, 4}
        };
    }
}
