package junyoung.week21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Week20JeongjySolutionTest {

    private Week21JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week21JeongjySolution();
    }

    @DisplayName("문자열 나누기")
    @ParameterizedTest
    @CsvSource({
            "banana, 3",
            "abracadabra, 6",
            "aaabbaccccabba, 3"
    })
    void splitStringTest(String s, int expected) {
        // given & when
        int actual = solution.splitString(s);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}