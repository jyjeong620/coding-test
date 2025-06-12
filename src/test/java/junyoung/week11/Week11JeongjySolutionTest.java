package junyoung.week11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Week11JeongjySolutionTest {
    @DisplayName("문자열 내림차순으로 배치하기")
    @ParameterizedTest
    @CsvSource({
            "Zbcdefg, gfedcbZ"
    })
    void sortStringTest(String s, String expect) {
        // given
        Week11JeongjySolution solution = new Week11JeongjySolution();

        // when
        String actual = solution.sortString(s);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("내적")
    @ParameterizedTest
    @MethodSource("dotProductProvider")
    void dotProductTest(int[] a, int[] b, int expect) {
        // given
        Week11JeongjySolution solution = new Week11JeongjySolution();

        // when
        int actual = solution.dotProduct(a, b);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> dotProductProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}, 3),
                Arguments.of(new int[]{-1, 0, 1}, new int[]{1, 0, -1}, -2)
        );
    }

    @DisplayName("문자열다루기기본")
    @ParameterizedTest
    @CsvSource({
            "a234, false",
            "1234, true"
    })
    void dealWithStringTest(String s, boolean expected) {
        // given
        Week11JeongjySolution solution = new Week11JeongjySolution();

        // when
        boolean actual = solution.dealWithString(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}