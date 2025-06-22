package yujin.week12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week12SolutionTest {
    @DisplayName("없는 숫자 더하기")
    @ParameterizedTest
    @MethodSource("addNotExistsNumbersTestCases")
    void addNotExistsNumbers(int[] numbers, int expected) {
        // given
        Week12Solution solution = new Week12Solution();

        // when & then
        assertThat(solution.addNotExistsNumbers(numbers)).isEqualTo(expected);
    }

    private static Stream<Arguments> addNotExistsNumbersTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 6, 7, 8, 0},
                        14
                ),
                Arguments.of(
                        new int[]{5, 8, 4, 0, 6, 7, 9},
                        6
                )
        );
    }

    @DisplayName("가운데 숫자 가져오기")
    @ParameterizedTest
    @CsvSource({"abcde,c", "qwer,we"})
    void pickMiddleValue(String s, String expected) {
        // given
        Week12Solution solution = new Week12Solution();

        // when & then
        assertThat(solution.pickMiddleValue(s)).isEqualTo(expected);
    }

    @DisplayName("문자열 내림차순으로 배치하기")
    @ParameterizedTest
    @CsvSource("Zbcdefg,gfedcbZ")
    void sortDescending(String s, String expected) {
        // given
        Week12Solution solution = new Week12Solution();

        // when & then
        assertThat(solution.sortDescending(s)).isEqualTo(expected);
    }
}