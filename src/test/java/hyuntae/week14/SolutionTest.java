package hyuntae.week14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("뒤에 있는 큰 수 찾기")
    @ParameterizedTest
    @MethodSource("findNextGreaterNumberTestCases")
    void findNextGreaterNumber(int[] numbers, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.findNextGreaterElement(numbers);

        // then
        assertThat(expected)
                .isEqualTo(result);
    }

    private static Object[][] findNextGreaterNumberTestCases() {
        return new Object[][]{
                {new int[]{2, 3, 3, 5, 5, 2}, new int[]{3, 5, 5, -1, -1, -1}},
                {new int[]{9, 1, 5, 3, 6}, new int[]{-1, 5, 6, 6, -1}},
                {new int[]{1, 2, 3}, new int[]{2, 3, -1}},
                {new int[]{4, 3, 2}, new int[]{-1, -1, -1}},
                {new int[]{7}, new int[]{-1}}
        };
    }

    @DisplayName("숫자 변환하기")
    @ParameterizedTest
    @MethodSource("transferNumberTestCases")
    void transferNumber(int x, int y, int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.transferNumber(x, y, n);

        // then
        assertThat(expected)
                .isEqualTo(result);
    }

    private static Object[][] transferNumberTestCases() {
        return new Object[][]{
                {10, 40, 5, 2},
                {10, 40, 30, 1},
                {2, 5, 3, 1},
                {5, 5, 5, 0},
                {1, 1000000, 999999, 1}
        };
    }

    @DisplayName("시소 짝꿍")
    @ParameterizedTest
    @MethodSource("seesawTestCases")
    void seesaw(int[] weights, int expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.seesaw(weights);

        // then
        assertThat(expected)
                .isEqualTo(result);
    }

    private static Object[][] seesawTestCases() {
        return new Object[][]{
                {new int[]{100, 200, 300, 400, 500}, 4},
                {new int[]{100, 200, 300, 400}, 4},
                {new int[]{100, 200, 300}, 2},
                {new int[]{100, 200}, 1},
                {new int[]{100}, 0}
        };
    }
}