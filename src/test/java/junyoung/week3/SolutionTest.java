package junyoung.week3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}