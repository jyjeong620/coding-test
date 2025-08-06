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
}