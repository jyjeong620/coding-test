package junyoung.week10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Week10JeongjySolutionTest {

    @DisplayName("문자열 내 마음대로 정렬하기")
    @ParameterizedTest
    @MethodSource("sortByMyMindProvider")
    void sortByMyMindTest(String[] strings, int n, String[] expect) {
        // given
        Week10JeongjySolution solution = new Week10JeongjySolution();

        // when
        String[] actual = solution.sortByMyMind(strings, n);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> sortByMyMindProvider() {
        return Stream.of(
                Arguments.of(new String[]{"sun", "bed", "car"}, 1, new String[]{"car", "bed", "sun"}),
                Arguments.of(new String[]{"abce", "abcd", "cdx"}, 2, new String[]{"abcd", "abce", "cdx"})
        );
    }

    @DisplayName("문자열내 p와y의 개수")
    @ParameterizedTest
    @CsvSource({
            "pPoooyY, true",
            "Pyy, false",
            "abc, true"
    })
    void countPAndYTest(String s, boolean expected) {
        // given
        Week10JeongjySolution solution = new Week10JeongjySolution();

        // when
        boolean actual = solution.countPAndY(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("K번째수")
    @ParameterizedTest
    @MethodSource("kNumberProvider")
    void kNumberTest(int[] array, int[][] commands, int[] expect) {
        // given
        Week10JeongjySolution solution = new Week10JeongjySolution();

        // when
        int[] actual = solution.kNumbers(array, commands);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> kNumberProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}, new int[]{5, 6, 3})
        );
    }
}