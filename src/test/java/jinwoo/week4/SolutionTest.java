package jinwoo.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @DisplayName("크기가 작은 부분문자열")
    @ParameterizedTest
    @CsvSource({
            "3141592, 271, 2",
            "500220839878, 7, 8",
            "10203, 15, 3"
    })
    void countLessOrEqualSubstringsTest(String t, String p, int expected) {
        // given

        // when
        int result = solution.countLessOrEqualSubstrings(t, p);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("가장 가까운 같은 글자")
    @ParameterizedTest
    @CsvSource({
            "banana, '-1 -1 -1 2 2 2'",
            "foobar, '-1 -1 1 -1 -1 -1'"
    })
    void findNearestSameCharacterTest(String s, String expectedStr) {
        // given
        int[] expected = parseExpectedArray(expectedStr);

        // when
        int[] result = solution.findNearestSameCharacter(s);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 나누기")
    @ParameterizedTest
    @CsvSource({
            "banana, 3",
            "abracadabra, 6",
            "aaabbaccccabba, 3"
    })
    void divideStringTest(String s, int expected) {
        // given

        // when
        int result = solution.divideString(s);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private int[] parseExpectedArray(String str) {
        String[] tokens = str.split(" ");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }
}
