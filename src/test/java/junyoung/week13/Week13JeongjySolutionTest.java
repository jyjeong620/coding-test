package junyoung.week13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week13JeongjySolutionTest {

    @DisplayName("시저암호")
    @ParameterizedTest
    @CsvSource ({
            "AB, 1, BC",
            "z, 1, a",
            "a B z, 4, e F d"
    })
    void caesarCipherTest(String s, int n, String expected) {
        // given
        Week13JeongjySolution solution = new Week13JeongjySolution();

        // when
        String actual = solution.caesarCipher(s, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}