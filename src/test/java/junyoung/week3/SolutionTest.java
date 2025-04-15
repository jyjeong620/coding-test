package junyoung.week3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @DisplayName("신규아이디 추천")
    @ParameterizedTest
    @CsvSource({
            "...!@BaT#*..y.abcdefghijklm, bat.y.abcdefghi",
            "z-+.^., z--",
            "=.=, aaa",
            "123_.def, 123_.def",
            "abcdefghijklmn.p, abcdefghijklmn",
    })
    void recommendId(String new_id, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String actual = solution.recommendId(new_id);

        // then
        assertThat(actual).isEqualTo(expected);
    }

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
}