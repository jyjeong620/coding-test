package yujin.week24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week24SolutionTest {
    @DisplayName("올바른 괄호")
    @ParameterizedTest
    @CsvSource({
            "'()()', true",
            "'(())()', true",
            "')()(', false",
            "'(()(', false"
    })
    void correctBrackets(String s, boolean expected) {
        Week24Solution solution = new Week24Solution();
        assertThat(solution.correctBrackets(s)).isEqualTo(expected);
    }

    @DisplayName("짝지어 제거하기")
    @ParameterizedTest
    @CsvSource({
            "'baabaa', 1",
            "'cdcd', 0"
    })
    void removePair(String s, int expected) {
        Week24Solution solution = new Week24Solution();
        assertThat(solution.removePair(s)).isEqualTo(expected);
    }

}