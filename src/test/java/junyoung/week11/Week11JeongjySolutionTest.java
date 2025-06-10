package junyoung.week11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}