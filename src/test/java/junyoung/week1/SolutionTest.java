package junyoung.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("약수의 합 테스트")
    @ParameterizedTest
    @CsvSource({
            "12, 28",
            "5, 6",
    })
    void sumDivisor1(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.sumDivisor(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

}