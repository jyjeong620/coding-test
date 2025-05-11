package hyuntae.week6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
    @DisplayName("가장 가까운 같은 글자")
    @ParameterizedTest
    @MethodSource("mostClosestString")
    void mostClosestString(String s, int[] expected) {
        Solution solution = new Solution();
        int[] result = solution.mostClosestString(s);
        Assertions.assertThat(expected).isEqualTo(result);
    }

    static Object[][] mostClosestString() {
        return new Object[][]{
                {"abca", new int[]{-1, -1, -1, 3}},
                {"aabb", new int[]{-1, 1, -1, 1}},
                {"a", new int[]{-1}},
                {"abcde", new int[]{-1, -1, -1, -1, -1}},
                {"aabbcc", new int[]{-1, 1, -1, 1, -1, 1}},
                {"abcabc", new int[]{-1, -1, -1, 3, 3, 3}},
        };
    }

    @DisplayName("숫자 문자열과 영단어")
    @ParameterizedTest
    @MethodSource("numberStringAndWords")
    void numberStringAndWords(String s, int expected) {
        Solution solution = new Solution();
        int result = solution.numberStringAndWords(s);
        Assertions.assertThat(expected).isEqualTo(result);
    }

    static Object[][] numberStringAndWords() {
        return new Object[][]{
                {"one4seveneight", 1478},
                {"23four5six7", 234567},
                {"2three45sixseven", 234567},
                {"123", 123},
                {"zero123", 123},
                {"zero", 0},
                {"1two3four5six7eight9zero", 1234567890}
        };
    }

    @DisplayName("부족한 금액 계산하기")
    @ParameterizedTest
    @MethodSource("calculateRestFee")
    void calculateRestFee(int price, int money, int count, long expected) {
        Solution solution = new Solution();
        long result = solution.calculateRestFee(price, money, count);
        Assertions.assertThat(expected).isEqualTo(result);
    }

    static Object[][] calculateRestFee() {
        return new Object[][]{
                {3, 20, 4, 10},
                {3, 0, 4, 30},
                {3, 5, 4, 25},
                {5, 5, 2, 10},
        };
    }
}