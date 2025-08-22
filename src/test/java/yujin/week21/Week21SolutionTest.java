package yujin.week21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week21SolutionTest {
    private Week21Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Week21Solution();
    }

    @DisplayName("크기가 작은 부분 문자열")
    @ParameterizedTest
    @CsvSource(value = {
            "3141692, 271, 2",
            "500220839878, 7, 8",
            "10203, 15, 3"
    })
    void partString(String t, String p, int expected) {
        assertThat(solution.partString(t, p)).isEqualTo(expected);
    }

    @DisplayName("3진법 뒤집기")
    @ParameterizedTest
    @CsvSource(value = {
            "45, 7",
            "125, 229"
    })
    void reverseNumber(int n, int expected) {
        assertThat(solution.reverseNumber(n)).isEqualTo(expected);
    }

    @DisplayName("최댓값과 최솟값")
    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4, 1 4", "-1 -2 -3 -4, -4 -1", "-1 -1, -1 -1"})
    void minAndMax(String s, String expected) {
        assertThat(solution.minAndMax(s)).isEqualTo(expected);
    }
}