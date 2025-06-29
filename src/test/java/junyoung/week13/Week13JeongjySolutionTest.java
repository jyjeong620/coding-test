package junyoung.week13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week13JeongjySolutionTest {
    private Week13JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week13JeongjySolution();
    }

    @DisplayName("시저암호")
    @ParameterizedTest
    @CsvSource({
            "AB, 1, BC",
            "z, 1, a",
            "a B z, 4, e F d"
    })
    void caesarCipherTest(String s, int n, String expected) {
        // when
        String actual = solution.caesarCipher(s, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이상한문자만들기")
    @ParameterizedTest
    @CsvSource({
            "try hello world, TrY HeLlO WoRlD",
            "' read the explanation carefully  ', ' ReAd ThE ExPlAnAtIoN CaReFuLlY  '"
    })
    void makeWeirdTextTest(String s, String expected) {
        // when
        String actual = solution.makeWeirdText(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}