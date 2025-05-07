package junyoung.week6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Week6JeongjySolutionTest {

    @DisplayName("명예의전당")
    @ParameterizedTest
    @MethodSource("hallOfFameProvider")
    void hallOfFame(int k, int[] score, int[] expected) {
        // given
        Week6JeongjySolution solution = new Week6JeongjySolution();

        // when
        int[] actual = solution.hallOfFame(k, score);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> hallOfFameProvider() {
        return Stream.of(
                Arguments.of(3, new int[]{10, 100, 20, 150, 1, 100, 200}, new int[]{10, 10, 10, 20, 20, 100, 100}),
                Arguments.of(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}, new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300})
        );
    }

}