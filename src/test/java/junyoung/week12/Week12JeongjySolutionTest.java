package junyoung.week12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week12JeongjySolutionTest {
    @DisplayName("소수찾기")
    @ParameterizedTest
    @CsvSource({
            "10, 4",
            "5, 3"
    })
    void findPrimeNumberTest(int n, int expected) {
        // given
        Week12JeongjySolution solution = new Week12JeongjySolution();

        // when
        int actual = solution.findPrimeNumber(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열을 정수로 바꾸기")
    @ParameterizedTest
    @CsvSource({
            "+1234, 1234",
            "-1234, -1234"
    })
    void changeToIntegerTest(String s, int expected) {
        // given
        Week12JeongjySolution solution = new Week12JeongjySolution();

        // when
        int actual = solution.changeToInteger(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다트게임")
    @ParameterizedTest
    @CsvSource({
            "1S2D*3T, 37",
            "1D2S#10S, 9",
            "1D2S0T, 3",
            "1S*2T*3S, 23",
            "1D#2S*3S, 5",
            "1T2D3D#, -4",
            "1D2S3T*, 59",
    })
    void dartGameTest(String s, int expected) {
        // given
        Week12JeongjySolution solution = new Week12JeongjySolution();

        // when
        int actual = solution.dartGame(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}