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

    @DisplayName("비밀 지도")
    @ParameterizedTest
    @MethodSource("secretMapTestCases")
    void secretMap(int n, int[] arr1, int[] arr2, String[] expected) {
        // given
        Week6Solution solution = new Week6Solution();

        // when
        String[] result = solution.secretMap(n, arr1, arr2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> secretMapTestCases() {
        return Stream.of(
                Arguments.of(
                        5,
                        new int[]{9, 20, 28, 18, 11},
                        new int[]{30, 1, 21, 17, 28},
                        new String[]{"#####", "# # #", "### #", "#  ##", "#####"}
                ),
                Arguments.of(
                        6,
                        new int[]{46, 33, 33, 22, 31, 50},
                        new int[]{27, 56, 19, 14, 14, 10},
                        new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}
                )
        );
    }
}