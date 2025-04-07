package junyoung.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {
    @DisplayName("짝수와 홀수")
    @ParameterizedTest
    @CsvSource({
            "1, Odd",
            "2, Even"
    })
    void evenOrOdd(int num, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String actual = solution.evenOrOdd(num);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}