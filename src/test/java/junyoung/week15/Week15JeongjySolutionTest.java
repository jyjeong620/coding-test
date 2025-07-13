package junyoung.week15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week15JeongjySolutionTest {
    @DisplayName("정수 제곱근 판별")
    @ParameterizedTest
    @MethodSource("getNextSquareOrMinusOneProvider")
    void getNextSquareOrMinusOneTest(long n, long expected) {
        // given
        Week15JeongjySolution solution = new Week15JeongjySolution();

        // when
        long result = solution.getNextSquareOrMinusOne(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> getNextSquareOrMinusOneProvider() {
        return Stream.of(
                Arguments.of(121L, 144L),
                Arguments.of(3L, -1L)
        );
    }

    @DisplayName("덧칠하기")
    @ParameterizedTest
    @MethodSource("overPaintingProvider")
    void overPainting(int n, int m, int[] section, int expected) {
        // given
        Week15JeongjySolution solution = new Week15JeongjySolution();

        // when
        int actual = solution.overpainting(n, m, section);

        //then
        assertThat(actual).isEqualTo(expected);
    }


    private static Stream<Arguments> overPaintingProvider() {
        return Stream.of(
                Arguments.of(8, 4, new int[]{2, 3, 6}, 2),
                Arguments.of(5, 4, new int[]{1, 3}, 1),
                Arguments.of(4, 1, new int[]{1, 2, 3, 4}, 4),
                Arguments.of(5, 2, new int[]{1, 4, 5}, 2),
                Arguments.of(10, 3, new int[]{1, 3, 6, 7}, 2)
        );
    }

    @DisplayName("나머지가 1이되는 수 찾기")
    @ParameterizedTest
    @CsvSource({
            "10, 3",
            "12, 11"
    })
    void remainderOneTest(int n, int expected) {
        // given
        Week15JeongjySolution solution = new Week15JeongjySolution();

        // when
        int actual = solution.remainderOne(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}