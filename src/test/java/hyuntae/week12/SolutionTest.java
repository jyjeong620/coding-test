package hyuntae.week12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("요격 시스템")
    @ParameterizedTest
    @MethodSource("ironDomeTestCases")
    void ironDome(int[][] targets, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.ironDome(targets);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] ironDomeTestCases() {
        return new Object[][]{
                {new int[][]{{1, 3}, {2, 4}, {3, 5}}, 2},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}}, 3},
                {new int[][]{{1, 5}, {2, 6}, {3, 7}}, 1},
                {new int[][]{{1, 10}, {2, 9}, {3, 8}}, 1},
                {new int[][]{{1, 2}, {3, 4}, {5, 6}}, 3}
        };
    }

    @DisplayName("과제 진행하기")
    @ParameterizedTest
    @MethodSource("proceedAssignmentTestCases")
    void proceedAssignment(String[][] plans, String[] expected) {
        // given
        Solution solution = new Solution();

        // when
        String[] result = solution.proceedAssignment(plans);

        // then
        assertThat(result).containsExactly(expected);
    }

    private static Object[][] proceedAssignmentTestCases() {
        return new Object[][]{
                {new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}, new String[]{"korean", "english", "math"}},
                {new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}, {"science", "13:00", "30"}}, new String[]{"korean", "english", "science", "math"}},
                {new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}, new String[]{"science", "history", "computer", "music"}}
        };
    }
}