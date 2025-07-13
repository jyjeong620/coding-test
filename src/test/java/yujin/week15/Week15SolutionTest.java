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

    @DisplayName("데이터 분석")
    @ParameterizedTest
    @MethodSource("analysisDataTestCases")
    void analysisData(int[][] data, String ext, int valExt, String sortBy, int[][] expected) {
        // when & then
        assertThat(solution.analysisData(data, ext, valExt, sortBy)).isEqualTo(expected);
    }

    public static Stream<Arguments> analysisDataTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                        "date",
                        20300501,
                        "remain",
                        new int[][]{{3, 20300401, 10, 8}, {1, 20300104, 100, 80}}
                )
        );
    }

    @DisplayName("크레인 인형뽑기 게임")
    @ParameterizedTest
    @MethodSource("clawMachineGameTestCases")
    void clawMachineGame(int[][] board, int[] moves, int expected) {
        // when & then
        assertThat(solution.clawMachineGame(board, moves)).isEqualTo(expected);
    }

    public static Stream<Arguments> clawMachineGameTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                        new int[]{1,5,3,5,1,2,1,4},
                        4
                )
        );
    }
}