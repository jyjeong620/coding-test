package yujin.week10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Week10SolutionTest {
    @DisplayName("둘만의 암호")
    @ParameterizedTest
    @CsvSource({
            "aukks,wbqd,5,happy",
            "z,abcdefghij,20,n"
    })
    void secretCode(String s, String skip, int index, String expected) {
        // given
        Week10Solution solution = new Week10Solution();

        // when
        String result = solution.secretCode(s, skip, index);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("p와 y의 개수")
    @ParameterizedTest
    @CsvSource({
            "pPoooyY,true",
            "Pyy,false"
    })
    void countOfPAndY(String s, boolean expected) {
        // given
        Week10Solution solution = new Week10Solution();

        // when
        boolean result = solution.countOfPAndY(s);

        // then
        assertThat(result).isEqualTo(expected);
    }
}