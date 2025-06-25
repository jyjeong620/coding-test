package hyuntae.week14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}