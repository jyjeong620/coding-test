package yujin.week13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week13SolutionTest {
    private Week13Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Week13Solution();
    }

    @DisplayName("다트 게임")
    @ParameterizedTest
    @CsvSource({
            "1S2D*3T,37",
            "1D2S#10S,9",
            "1D2S0T,3",
            "1S*2T*3S,23",
            "1D#2S*3S,5",
            "1T2D3D#,-4",
            "1D2S3T*,59"
    })
    void dartGame(String dartResult, int expected) {
        // when & then
        assertThat(solution.dartGame(dartResult)).isEqualTo(expected);
    }

    @DisplayName("체육복")
    @ParameterizedTest
    @MethodSource("workoutClothesTestCases")
    void workoutClothes(int n, int[] lost, int[] reserve, int expected) {
        // when & then
        assertThat(solution.workoutClothes(n, lost, reserve)).isEqualTo(expected);
    }

    private static Stream<Arguments> workoutClothesTestCases() {
        return Stream.of(
                Arguments.of(
                        5,
                        new int[]{2, 4},
                        new int[]{1, 3, 5},
                        5
                ),
                Arguments.of(
                        5,
                        new int[]{2, 4},
                        new int[]{3},
                        4
                ),
                Arguments.of(
                        3,
                        new int[]{3},
                        new int[]{1},
                        2
                ),
                Arguments.of(
                        5,
                        new int[]{3, 1},
                        new int[]{2, 4},
                        5
                ),
                Arguments.of(
                        5,
                        new int[]{2, 3},
                        new int[]{3, 4},
                        4
                ),
                Arguments.of(
                        5,
                        new int[]{2, 4},
                        new int[]{3, 4},
                        5
                )
        );
    }
}