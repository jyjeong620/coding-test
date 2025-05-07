package yujin.week6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week6SolutionTest {
    @DisplayName("시저 암호")
    @ParameterizedTest
    @CsvSource({
            "AB,1,BC",
            "z,1,a",
            "a B z,4,e F d",
    })
    void caesarPassword(String s, int n, String expected) {
        // given
        Week6Solution solution = new Week6Solution();

        // when
        String result = solution.caesarPassword(s, n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("예산")
    @ParameterizedTest
    @MethodSource("budgetTestCases")
    void budget(int[] d, int budget, int expected) {
        // given
        Week6Solution solution = new Week6Solution();

        // when
        int result = solution.budget(d, budget);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> budgetTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 2, 5, 4},
                        9,
                        3
                ),
                Arguments.of(
                        new int[]{2, 2, 3, 3},
                        10,
                        4
                )
        );
    }
}