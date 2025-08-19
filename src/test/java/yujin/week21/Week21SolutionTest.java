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
}