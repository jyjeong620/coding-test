package yujin.week9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("이상한 문자 만들기")
    @ParameterizedTest
    @CsvSource({
            "try hello world, TrY HeLlO WoRlD",
    })
    void createStrangeCharacters(String s, String expected) {
        // given
        Week9Solution solution = new Week9Solution();

        // when
        String result = solution.createStrangeCharacters(s);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("최소 직사각형")
    @ParameterizedTest
    @MethodSource("minimumRectangleTestCases")
    void minimumRectangle(int[][] sizes, int expected) {
        // given
        Week9Solution solution = new Week9Solution();

        // when
        int result = solution.minimumRectangle(sizes);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> minimumRectangleTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                        4000
                ),
                Arguments.of(
                        new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                        120
                ),
                Arguments.of(
                        new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
                        133
                )
        );
    }
}