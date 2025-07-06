package yujin.week14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week14SolutionTest {
    private Week14Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Week14Solution();
    }

    @DisplayName("이웃한 칸")
    @ParameterizedTest
    @MethodSource("neighborTestCases")
    void neighbor(String[][] board, int h, int w, int expected) {
        // when & then
        assertThat(solution.neighbor(board, h, w)).isEqualTo(expected);
    }

    private static Stream<Arguments> neighborTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[][]{
                                {"blue", "red", "orange", "red"},
                                {"red", "red", "blue", "orange"},
                                {"blue", "orange", "red", "red"},
                                {"orange", "orange", "red", "blue"}
                        },
                        1, 1, 2
                ),
                Arguments.of(
                        new String[][]{
                                {"yellow", "green", "blue"},
                                {"blue", "green", "yellow"},
                                {"7", "8", "9"}
                        },
                        0, 1, 1
                )
        );
    }

    @DisplayName("완주하지 못한 선수")
    @ParameterizedTest
    @MethodSource("notFinishedRunnerTestCases")
    void notFinishedRunner(String[] participant, String[] completion, String expected) {
        // when & then
        assertThat(solution.notFinishedRunner(participant, completion)).isEqualTo(expected);
    }

    private static Stream<Arguments> notFinishedRunnerTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"leo", "kiki", "eden"},
                        new String[]{"eden", "kiki"},
                        "leo"
                ),
                Arguments.of(
                        new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                        new String[]{"josipa", "filipa", "marina", "nikola"},
                        "vinko"
                ),
                Arguments.of(
                        new String[]{"mislav", "stanko", "mislav", "ana"},
                        new String[]{"stanko", "ana", "mislav"},
                        "mislav"
                )
        );
    }

    @DisplayName("숫자 짝꿍")
    @ParameterizedTest
    @CsvSource({
            "100,2345,-1",
            "100,203045,0",
            "100,123450,10",
            "12321,42531,321",
            "5525,1255,552"
    })
    void numberPair(String x, String y, String expected) {
        // when & then
        assertThat(solution.numberPair(x, y)).isEqualTo(expected);
    }
}