package hyuntae.week11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("덧칠하기")
    @ParameterizedTest
    @MethodSource("repaintTestCases")
    void repaintTest(int n, int m, int[] section, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.repaint(n, m, section);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] repaintTestCases() {
        return new Object[][]{
                {8, 4, new int[]{2, 3, 6}, 2},
                {5, 1, new int[]{1, 2, 3, 4, 5}, 5},
                {10, 2, new int[]{1, 3, 5, 7, 9}, 5},
                {7, 3, new int[]{1, 2, 4}, 2},
                {10, 5, new int[]{1, 6}, 2}
        };
    }

    @DisplayName("서버 증설")
    @ParameterizedTest
    @MethodSource("increaseServerTestCases")
    void increaseServerTest(int[] players, int m, int k, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.increaseServer(players, m, k);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] increaseServerTestCases() {
        return new Object[][]{
                {new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5, 7},
                {new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1, 11},
                {new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1, 12},
        };
    }

    @DisplayName("택배 상자")
    @ParameterizedTest
    @MethodSource("parcelBoxTestCases")
    void parcelBoxTest(int[] order, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.parcelBox(order);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] parcelBoxTestCases() {
        return new Object[][]{
                {new int[]{4, 3, 1, 2, 5}, 2},
                {new int[]{1, 2, 3, 4, 5}, 5},
                {new int[]{5, 4, 3, 2, 1}, 5},
                {new int[]{1, 3, 2, 5, 4}, 5},
                {new int[]{2, 1, 4, 3, 5}, 5}
        };
    }
}
