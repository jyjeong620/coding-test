package yujin.week19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        assertArrayEquals(expected, result);
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
        assertArrayEquals(expected, result);
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
}