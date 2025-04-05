package yujin.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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

    @DisplayName("자릿수 더하기")
    @ParameterizedTest
    @CsvSource({
            "123,6",
            "987,24"
    })
    void sumDigitsTest(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.sumDigits(n);

        // when
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("자연수 뒤집어 배열로 만들기")
    @ParameterizedTest
    @CsvSource({
            "12345,'5,4,3,2,1'",
            "10000000000, '0,0,0,0,0,0,0,0,0,0,1'"
    })
    void reverseNumberToArray(long n, String expectedAsString) {
        // given
        Solution solution = new Solution();

        String[] parts = expectedAsString.split(",");
        int[] expected = Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .toArray();

        // when
        int[] result = solution.reverseNumberToArray(n);

        // then
        assertThat(result).isEqualTo(expected);
    }
}