package junyoung.week20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week21JeongjySolutionTest {
    private Week20JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week20JeongjySolution();
    }

    @DisplayName("롤케이크 자르기")
    @ParameterizedTest
    @MethodSource("rollCakeCuttingProvider")
    void rollCakeCuttingTest(int[] topping, int expected) {
        // given & when
        int actual = solution.rollCakeCutting(topping);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> rollCakeCuttingProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 3, 1, 4, 1, 2}, 2),
                Arguments.of(new int[]{1, 2, 3, 1, 4}, 0)
        );
    }

    @DisplayName("약수의 개수와 덧셈")
    @ParameterizedTest
    @CsvSource({
            "13, 17, 43",
            "24, 27, 52"
    })
    void divisorCountAndSumTest(int left, int right, int expected) {
        // given & when
        int actual = solution.divisorCountAndSum(left, right);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("과일 장수")
    @ParameterizedTest
    @MethodSource("fruitSellerProvider")
    void fruitSellerTest(int k, int m, int[] score, int expected) {
        // given & when
        int actual = solution.fruitSeller(k, m, score);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> fruitSellerProvider() {
        return Stream.of(
                Arguments.of(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}, 8),
                Arguments.of(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}, 33)
        );
    }
}