package yujin.week7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week7SolutionTest {
    @DisplayName("음양 더하기")
    @ParameterizedTest
    @MethodSource("plusYinAndYangTestCases")
    void plusYinAndYang(int[] absolutes, boolean[] signs, int expected) {
        // given
        Week7Solution solution = new Week7Solution();

        // when
        int result = solution.plusYinAndYang(absolutes, signs);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> plusYinAndYangTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 7, 12},
                        new boolean[]{true, false, true},
                        9
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        new boolean[]{false, false, true},
                        0
                )
        );
    }

    @DisplayName("모의고사")
    @ParameterizedTest
    @MethodSource("mockTestTestCases")
    void mockTest(int[] answers, int[] expected) {
        // given
        Week7Solution solution = new Week7Solution();

        // when
        int[] result = solution.mockTest(answers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> mockTestTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{1, 3, 2, 4, 2},
                        new int[]{1, 2, 3}
                )
        );
    }

    @DisplayName("과일 장수")
    @ParameterizedTest
    @MethodSource("fruitSellerTestCases")
    void fruitSeller(int k, int m, int[] score, int expected) {
        // given
        Week7Solution solution = new Week7Solution();

        // when
        int result = solution.fruitSeller(k, m, score);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> fruitSellerTestCases() {
        return Stream.of(
                Arguments.of(
                        3, 4,
                        new int[]{1, 2, 3, 1, 2, 3, 1},
                        8
                ),
                Arguments.of(
                        4, 3,
                        new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2},
                        33
                )
        );
    }
}