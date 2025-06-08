package hyuntae.week10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("같은 숫자는 싫어")
    @ParameterizedTest
    @MethodSource("iHateSameNumberTestCases")
    void iHateSameNumber(int[] arr, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.iHateSameNumber(arr);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] iHateSameNumberTestCases() {
        return new Object[][]{
                {new int[]{1, 1, 3, 3, 0, 1, 1}, new int[]{1, 3, 0, 1}},
                {new int[]{4, 4, 4, 3, 3}, new int[]{4, 3}},
                {new int[]{7, 8, 8, 7}, new int[]{7, 8, 7}},
                {new int[]{2}, new int[]{2}},
                {new int[]{}, new int[]{}}
        };
    }

    @DisplayName("자연수 뒤집어 배열로 만들기")
    @ParameterizedTest
    @MethodSource("reverseNumberToArrayTestCases")
    void reverseNumberToArray(long n, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.reverseNumberToArray(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] reverseNumberToArrayTestCases() {
        return new Object[][]{
                {12345L, new int[]{5, 4, 3, 2, 1}},
                {10000000000L, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}},
                {987654321L, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {0L, new int[]{0}}
        };
    }

    @DisplayName("정수 제곱근 판별")
    @ParameterizedTest
    @MethodSource("integerSquareRootDeterminationTestCases")
    void integerSquareRootDetermination(long n, long expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.integerSquareRootDetermination(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] integerSquareRootDeterminationTestCases() {
        return new Object[][]{
                {16L, 25L},
                {20L, -1L},
                {1L, 4L},
                {9L, 16L}
        };
    }
}