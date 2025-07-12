package yujin.week15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week15SolutionTest {
    private Week15Solution solution;

    @BeforeEach
    void setup() {
        solution = new Week15Solution();
    }

    @DisplayName("햄버거 만들기")
    @ParameterizedTest
    @MethodSource("makeHamburgerTestCases")
    void makeHamburger(int[] ingredient, int expected) {
        // when & then
        assertThat(solution.makeHamburger(ingredient)).isEqualTo(expected);
    }

    public static Stream<Arguments> makeHamburgerTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1},
                        2
                ),
                Arguments.of(
                        new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2},
                        0
                ),
                Arguments.of(
                        new int[]{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1},
                        3
                )
        );
    }
}