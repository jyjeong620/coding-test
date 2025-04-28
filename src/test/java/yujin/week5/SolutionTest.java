package yujin.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("명예의 전당")
    @ParameterizedTest
    @MethodSource("hallOfFameTestCases")
    void hallOfFame(int k, int[] score, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.hallOfFame(k, score);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> hallOfFameTestCases() {
        return Stream.of(
                Arguments.of(
                        3,
                        new int[]{10, 100, 20, 150, 1, 100, 200},
                        new int[]{10, 10, 10, 20, 20, 100, 100}
                ),
                Arguments.of(
                        4,
                        new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000},
                        new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300}
                )
        );
    }
}