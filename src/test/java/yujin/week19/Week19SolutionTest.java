package yujin.week19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week19SolutionTest {
    private Week19Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Week19Solution();
    }

    @DisplayName("달리기 경주")
    @ParameterizedTest
    @MethodSource("runningRaceTestCases")
    void runningRace(String[] players, String[] callings, String[] expected) {
        // when
        String[] result = solution.runningRace(players, callings);

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> runningRaceTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"mumu", "soe", "poe", "kai", "mine"},
                        new String[]{"kai", "kai", "mine", "mine"},
                        new String[]{"mumu", "kai", "mine", "soe", "poe"}
                )
        );
    }

    @DisplayName("공원 산책")
    @ParameterizedTest
    @MethodSource("walkPartTestCases")
    void walkPark(String[] park, String[] routes, int[] expected) {
        // when
        int[] result = solution.walkPark(park, routes);

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> walkPartTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"SOO", "OOO", "OOO"},
                        new String[]{"E 2", "S 2", "W 1"},
                        new int[]{2, 1}
                ),
                Arguments.of(
                        new String[]{"SOO", "OXX", "OOO"},
                        new String[]{"E 2", "S 2", "W 1"},
                        new int[]{0, 1}
                ),
                Arguments.of(
                        new String[]{"OSO", "OOO", "OXO", "OOO"},
                        new String[]{"E 2", "S 3", "W 1"},
                        new int[]{0, 0}
                )
        );
    }

    @DisplayName("붕대 감기")
    @ParameterizedTest
    @MethodSource("wrapBandageTestCases")
    void wrapBandage(int[] bandage, int health, int[][] attacks, int expected) {
        // when
        int result = solution.wrapBandage(bandage, health, attacks);

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> wrapBandageTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 1, 5},
                        30,
                        new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}},
                        5
                ),
                Arguments.of(
                        new int[]{3, 2, 7},
                        20,
                        new int[][]{{1, 15}, {5, 16}, {8, 6}},
                        -1
                ),
                Arguments.of(
                        new int[]{4, 2, 7},
                        20,
                        new int[][]{{1, 15}, {5, 16}, {8, 6}},
                        -1
                ),
                Arguments.of(
                        new int[]{1, 1, 1},
                        5,
                        new int[][]{{1, 2}, {3, 2}},
                        3
                )
        );
    }
}