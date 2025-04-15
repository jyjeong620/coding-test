package yujin.week3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("나머지가 1이 되는 수 찾기")
    @ParameterizedTest
    @CsvSource({
            "10,3",
            "12,11"
    })
    void findNumberWithRemainderOne(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.findNumberWithRemainderOne(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열을 정수로 바꾸기")
    @ParameterizedTest
    @CsvSource({
            "1234,1234",
            "-1234,1234"
    })
    void parseInt(String s, long expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.parseInt(s);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 정수 사이의 합")
    @ParameterizedTest
    @CsvSource({
            "3,5,12",
            "3,3,3",
            "5,3,12"
    })
    void sumBetween(int a, int b, long expected) {
        // given
        Solution solution = new Solution();

        // when
        long result = solution.sumBetween(a, b);

        // then
        assertThat(result).isEqualTo(expected);
    }
}