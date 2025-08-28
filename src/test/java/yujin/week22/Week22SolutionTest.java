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
}