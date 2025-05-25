package hyuntae.week8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("완주하지 못한 선수")
    @ParameterizedTest
    @MethodSource("participantWhoDidNotFinish")
    void participantWhoDidNotFinish(String[] participant, String[] completion, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.participantWhoDidNotFinish(participant, completion);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Object[][] participantWhoDidNotFinish() {
        return new Object[][]{
                {new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}, "leo"},
                {new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}, "vinko"},
                {new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}, "mislav"}
        };
    }

    @DisplayName("k번째 수")
    @ParameterizedTest
    @MethodSource("kthNumber")
    void kthNumber(int[] array, int[][] commands, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.k_thNumber(array, commands);

        // then
        assertThat(expected).isEqualTo(result);
    }

    static Object[][] kthNumber() {
        return new Object[][]{
                {new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}, new int[]{5, 6, 3}},
                {new int[]{10, 20, 30, 40}, new int[][]{{1, 2, 1}, {2, 4, 2}}, new int[]{10, 30}}
        };
    }

    @DisplayName("모의고사")
    @ParameterizedTest
    @MethodSource("mockTest")
    void mockTest(int[] answers, Integer[] expected) {
        // given
        Solution solution = new Solution();

        // when
        Integer[] result = solution.mockTest(answers);

        // then
        assertThat(expected).isEqualTo(result);
    }

    static Object[][] mockTest() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new Integer[]{1}},
                {new int[]{1, 3, 2, 4, 2}, new Integer[]{1, 2, 3}}
        };
    }
}