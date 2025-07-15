package junyoung.week16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week16JeongjySolutionTest {
    Week16JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week16JeongjySolution();
    }

    @DisplayName("JadenCase 문자열 만들기")
    @ParameterizedTest
    @CsvSource({
            "3people unFollowed me, 3people Unfollowed Me",
            "for the last week, For The Last Week",
            "' 3people unFollowed me', ' 3people Unfollowed Me'",
            "'  for the what 1what  ', '  For The What 1what  '"
    })
    void makeJadenCaseStringTest(String s, String expected) {
        // given & when
        String actual = solution.makeJadenCaseString(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}