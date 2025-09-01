package yujin.week22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week22SolutionTest {
    private final Week22Solution solution = new Week22Solution();

    @DisplayName("신고 결과 받기")
    @ParameterizedTest
    @MethodSource("reportTestCases")
    void report(String[] idList, String[] report, int k, int[] expected) {
        assertThat(solution.report(idList, report, k)).isEqualTo(expected);
    }

    static Stream<Arguments> reportTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2,
                        new int[]{2, 1, 1, 0}
                ),
                Arguments.of(
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3,
                        new int[]{0, 0}
                )
        );
    }

    @DisplayName("JadenCase 문자열 만들기")
    @ParameterizedTest
    @CsvSource({
            "3people unFollowed me,3people Unfollowed Me",
            "for the last week,For The Last Week",
            "'  for the what  1what  ','  For The What  1what  '"
    })
    void makeJadenCase(String s, String expected) {
        assertThat(solution.makeJadenCase(s)).isEqualTo(expected);
    }

    @DisplayName("최솟값 만들기")
    @ParameterizedTest
    @MethodSource("makeMinNumberTestCases")
    void makeMinNumber(int[] a, int[] b, int expected) {
        assertThat(solution.makeMinNumber(a, b)).isEqualTo(expected);
    }

    static Stream<Arguments> makeMinNumberTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 2}, new int[]{5, 4, 4}, 29),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 10)
        );
    }
}