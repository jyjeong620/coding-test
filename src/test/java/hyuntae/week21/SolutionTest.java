package hyuntae.week21;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @DisplayName("지폐 접기")
    @ParameterizedTest
    @MethodSource("billFoldingTestCases")
    void billFolding(int[] n, int[] m, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.billFolding(n, m);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] billFoldingTestCases() {
        return new Object[][]{
                {new int[]{10, 15}, new int[]{2, 3}, 0},
                {new int[]{50, 50}, new int[]{100, 241}, 4},
                {new int[]{30, 20}, new int[]{10, 10}, 0},
                {new int[]{5, 5}, new int[]{6, 6}, 2},
                {new int[]{100, 200}, new int[]{50, 50}, 0}
        };
    }

    @DisplayName("동영상 재생기")
    @ParameterizedTest
    @MethodSource("videoPlayerTestCases")
    void videoPlayer(String playList, String k, String start, String end, String[] commands, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.videoPlayer(playList, k, start, end, commands);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> videoPlayerTestCases() {
        return Stream.of(
                Arguments.of("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}, "13:00"),
                Arguments.of("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}, "06:55"),
                Arguments.of("07:22", "04:05", "00:15", "04:07", new String[]{"next"}, "04:17")
        );
    }

    @DisplayName("시저 암호")
    @ParameterizedTest
    @MethodSource("caesarCipherTestCases")
    void caesarCipher(String s, int n, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.caesarCipher(s, n);

        // then
        assertEquals(expected, result);
    }

    private static Object[][] caesarCipherTestCases() {
        return new Object[][]{
                {"AB", 1, "BC"},
                {"z", 1, "a"},
                {"a B z", 4, "e F d"},
                {"xyz XYZ", 3, "abc ABC"}
        };
    }
}