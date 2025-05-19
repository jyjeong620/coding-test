package yujin.week8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week8SolutionTest {
    @DisplayName("덧칠하기")
    @ParameterizedTest
    @MethodSource("overPaintingTestCases")
    void overPainting(int n, int m, int[] section, int expected) {
        // given
        Week8Solution solution = new Week8Solution();

        // when
        int result = solution.overPainting(n, m, section);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> overPaintingTestCases() {
        return Stream.of(
                Arguments.of(
                        8, 4,
                        new int[]{2, 3, 6},
                        2
                ),
                Arguments.of(
                        5, 4,
                        new int[]{1, 3},
                        1
                ),
                Arguments.of(
                        4, 1,
                        new int[]{1, 2, 3, 4},
                        4
                ),
                Arguments.of(
                        5, 2,
                        new int[]{1, 4, 5},
                        2
                )
        );
    }
}