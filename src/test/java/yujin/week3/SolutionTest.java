package yujin.week3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
            "-1234,-1234"
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

    @DisplayName("가장 가까운 같은 글자")
    @ParameterizedTest
    @CsvSource({
            "banana, '-1,-1,-1,2,2,2'",
            "foobar, '-1,-1,1,-1,-1,-1'"
    })
    void nearestSameCharacter(String s, String expectedAsString) {
        // given
        Solution solution = new Solution();

        int[] expected = Arrays.stream(expectedAsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // when
        int[] result = solution.nearestSameCharacter(s);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("폰켓몬")
    @ParameterizedTest
    @CsvSource({
            "'3,1,2,3', 2",
            "'3,3,3,2,2,4', 3",
            "'3,3,3,2,2,2', 2"
    })
    void ponketmon(String numAsString, int expected) {
        // given
        Solution solution = new Solution();
        int[] nums = Arrays.stream(numAsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // when
        int result = solution.ponketmon(nums);

        // then
        assertThat(result).isEqualTo(expected);
    }
}