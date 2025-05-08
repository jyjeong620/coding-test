package junyoung.week6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> hallOfFameProvider() {
        return Stream.of(
                Arguments.of(3, new int[]{10, 100, 20, 150, 1, 100, 200}, new int[]{10, 10, 10, 20, 20, 100, 100}),
                Arguments.of(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}, new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300})
        );
    }

    @DisplayName("콜라문제")
    @ParameterizedTest
    @CsvSource({
            "2, 1, 20, 19",
            "3, 1, 20, 9",
            "5, 3, 21, 27"
    })
    void colaTest(int a, int b, int n, int expected) {
        // given
        Week6JeongjySolution solution = new Week6JeongjySolution();

        // when
        int actual = solution.cola(a, b, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}