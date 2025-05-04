package hyuntae.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("카드 뭉치")
    @ParameterizedTest
    @MethodSource("cardProvider")
    void card(String[] cards1, String[] cards2, String[] goal, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String actual = solution.card(cards1, cards2, goal);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[][] cardProvider() {
        return new Object[][]{
                {new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}, "Yes"},
                {new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}, "No"},
                {new String[]{"i", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}, "No"},
        };
    }

    @DisplayName("추억 점수")
    @ParameterizedTest
    @MethodSource("memoryScoreProvider")
    void memoryScore(String[] name, int[] yearning, String[][] photo, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] actual = solution.memoryScore(name, yearning, photo);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[][] memoryScoreProvider() {
        return new Object[][]{
                {new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}}, new int[]{19, 15}},
                {new String[]{"kali", "mari", "don"}, new int[]{11, 1, 55}, new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}, new int[]{67, 0, 55}},
                {new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}}, new int[]{5, 15, 0}},
        };
    }

    @DisplayName("크기가 작은 부분 문자열")
    @ParameterizedTest
    @MethodSource("smallSubstringsProvider")
    void smallSubstrings(String t, String p, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int actual = solution.smallSubstrings(t, p);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[][] smallSubstringsProvider() {
        return new Object[][]{
                {"3141592", "271", 2},
                {"500220839878", "7", 8},
                {"10203", "15", 3},
        };
    }
}