package hyuntae.week15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @DisplayName("나머지가 1이 되는 수 찾기")
    @ParameterizedTest
    @MethodSource("findRemainsOneTestCases")
    void findRemainsOne(int n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.findRemainsOne(n);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] findRemainsOneTestCases() {
        return new Object[][]{
                {10, 3},
                {12, 11},
        };
    }

    @DisplayName("모음 사전")
    @ParameterizedTest
    @MethodSource("vowelDictionaryTestCases")
    void vowelDictionary(String word, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.vowelDictionary(word);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] vowelDictionaryTestCases() {
        return new Object[][]{
                {"AAAAE", 6},
                {"AAAE", 10},
                {"I", 1563},
                {"EIO", 1189},
        };
    }

    @DisplayName("삼각형 달팽이")
    @ParameterizedTest
    @MethodSource("triangleSnailTestCases")
    void triangleSnail(int n, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.triangleSnail(n);

        // then
        assertArrayEquals(expected, result);
    }

    private static Object[][] triangleSnailTestCases() {
        return new Object[][]{
                {4, new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7}},
                {5, new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}},
                {6, new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}},
        };
    }
}