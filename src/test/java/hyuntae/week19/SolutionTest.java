package hyuntae.week19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @DisplayName("주식가격")
    @ParameterizedTest
    @MethodSource("stockPriceTestCases")
    void maxProfit(int[] prices, int[] expected) {
        Solution solution = new Solution();

        // when
        int[] result = solution.stockPrice(prices);

        // then
        assertArrayEquals(expected, result);
    }

    private static Object[][] stockPriceTestCases() {
        return new Object[][]{
                {new int[]{1, 2, 3, 2, 3}, new int[]{4, 3, 1, 1, 0}},
        };
    }

    @DisplayName("피보나치")
    @ParameterizedTest
    @MethodSource("fibonacciTestCases")
    void fibonacci(int n, int expected) {
        Solution solution = new Solution();

        // when
        int result = solution.fibonacci(n);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] fibonacciTestCases() {
        return new Object[][]{
                {3, 2},
                {5, 5},
        };
    }

    @DisplayName("하노이의 탑")
    @ParameterizedTest
    @MethodSource("hanoiTestCases")
    void hanoi(int n, int[][] expected) {
        Solution solution = new Solution();

        // when
        int[][] result = solution.hanoi(n);

        // then
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> hanoiTestCases() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 2}, {1, 3}, {2, 3}})
        );
    }
}