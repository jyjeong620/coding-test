package yujin.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("약수의 합")
    @ParameterizedTest
    @CsvSource({
            "12,28",
            "5,6"
    })
    void sumOfDivisorsTest(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.sumOfDivisors(n);

        // when
        assertThat(result).isEqualTo(expected);
    }
}