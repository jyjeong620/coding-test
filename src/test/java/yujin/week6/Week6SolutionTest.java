package yujin.week6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week6SolutionTest {
    @DisplayName("시저 암호")
    @ParameterizedTest
    @CsvSource({
            "AB,1,BC",
            "z,1,a",
            "a B z,4,e F d",
    })
    void caesarPassword(String s, int n, String expected) {
        // given
        Week6Solution solution = new Week6Solution();

        // when
        String result = solution.caesarPassword(s, n);

        // then
        assertThat(result).isEqualTo(expected);
    }
}