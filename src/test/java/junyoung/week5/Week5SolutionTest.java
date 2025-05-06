package junyoung.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Week5SolutionTest {

    @DisplayName("둘만의 암호")
    @ParameterizedTest
    @CsvSource({
            "aukks, wbqd, 5, happy"
    })
    void ourPasswordTest(String s, String skip, int index, String expected) {
        // given
        Week5Solution solution = new Week5Solution();

        // when
        String actual = solution.ourPassword(s, skip, index);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("햄버거 만들기")
    @ParameterizedTest
    @MethodSource("makeHamburgerProvider")
    void makeHamburgerTest(int[] ingredients, int expected) {
        // given
        Week5Solution solution = new Week5Solution();

        // when
        int actual = solution.makeHamburger(ingredients);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> makeHamburgerProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}, 2),
                Arguments.of(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}, 0)
        );
    }

    @DisplayName("콜라츠 추측")
    @ParameterizedTest
    @CsvSource({
            "6, 8",
            "16, 4",
            "626331, -1",
            "1, 0"
    })
    void collatzConjectureTest(int num, int expected) {
        // given
        Week5Solution solution = new Week5Solution();
        // when
        int actual = solution.collatzConjecture(num);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}