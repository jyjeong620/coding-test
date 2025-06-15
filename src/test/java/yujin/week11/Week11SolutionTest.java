package yujin.week11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week11SolutionTest {
    @DisplayName("수박수박수박수박수박수?")
    @ParameterizedTest
    @CsvSource({
            "3,수박수",
            "4,수박수박"
    })
    void watermelon(int n, String expected) {
        // given
        Week11Solution solution = new Week11Solution();

        // when
        String result = solution.watermelon(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 다루기 기본")
    @ParameterizedTest
    @CsvSource({
            "a234,false",
            "1234,true"
    })
    void basicString(String s, boolean expected) {
        // given
        Week11Solution solution = new Week11Solution();

        // when
        boolean result = solution.basicString(s);

        // when
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 개 뽑아서 더하기")
    @ParameterizedTest
    @MethodSource("pickTwoAndSumTestCases")
    void pickTwoAndSum(int[] numbers, int[] expected) {
        // given
        Week11Solution solution = new Week11Solution();

        // when
        int[] result = solution.pickTwoAndSum(numbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> pickTwoAndSumTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 1, 3, 4, 1},
                        new int[]{2, 3, 4, 5, 6, 7}
                ),
                Arguments.of(
                        new int[]{5, 0, 2, 7},
                        new int[]{2, 5, 7, 9, 12}
                )
        );
    }
}