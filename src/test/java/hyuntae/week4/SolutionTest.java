package hyuntae.week4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource({
            "12, 28",
            "5, 6",
    })
    void sumOfDivisors(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.sumOfDivisors(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "123, 6",
            "987, 24"
    })
    void sumDigits(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.sumDigits(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "12345, 54321",
            "9876543210, 0123456789"
    })
    void reverseNumberToArray(long n, String answer) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.reverseNumberToArray(n);
        int[] expected = Arrays.stream(answer.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        // then
        assertThat(result).isEqualTo(expected);
    }
}