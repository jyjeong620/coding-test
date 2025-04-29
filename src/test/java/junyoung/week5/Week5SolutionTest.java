package junyoung.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class Week5SolutionTest {

    @DisplayName("둘만의 암호")
    @ParameterizedTest
    @CsvSource({
        "aukks, wbqd, 5, happy"
    })
    void ourPasswordTest(String s, String skip, int index, String expected) {
        // given
        Week5Solution solution = new Week5Solution();

        // when
        String actual = solution.ourPassword(s, skip, index);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}