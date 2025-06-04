package junyoung.week10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Week10JeongjySolutionTest {

    @DisplayName("문자열 내 마음대로 정렬하기")
    @ParameterizedTest
    @MethodSource("sortByMyMindProvider")
    void sortByMyMind(String[] strings, int n, String[] expect) {
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
}