package yujin.week9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week9SolutionTest {
    @DisplayName("내적")
    @ParameterizedTest
    @MethodSource("dotProductTestCases")
    void dotProduct(int[] a, int[] b, int expected) {
        // given
        Week9Solution solution = new Week9Solution();

        // when
        int result = solution.dotProduct(a, b);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> dotProductTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{-3, -1, 0, 2},
                        3
                ),
                Arguments.of(
                        new int[]{-1, 0, 1},
                        new int[]{1, 0, -1},
                        -2
                )
        );
    }
}