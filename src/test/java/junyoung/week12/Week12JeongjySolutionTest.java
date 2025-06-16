package junyoung.week12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week12JeongjySolutionTest {
    @DisplayName("소수찾기")
    @ParameterizedTest
    @CsvSource({
            "10, 4",
            "5, 3"
    })
    void findPrimeNumberTest(int n, int expected) {
        // given
        Week12JeongjySolution solution = new Week12JeongjySolution();

        // when
        int actual = solution.findPrimeNumber(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}