package junyoung.week8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Week8JeongjySolutionTest {

    @DisplayName("대충만든 자판")
    @ParameterizedTest
    @MethodSource("keyboardProvider")
    void keyboardTest(String[] keymaps, String[] targets, int[] expected) {
        // given
        Week8JeongjySolution solution = new Week8JeongjySolution();

        // when
        int[] actual = solution.keyboard(keymaps, targets);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> keyboardProvider() {
        return Stream.of(
                Arguments.of(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"}, new int[]{9, 4}),
                Arguments.of(new String[]{"AA"}, new String[]{"B"}, new int[]{-1}),
                Arguments.of(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"}, new int[]{4,6}),
                Arguments.of(new String[]{"ABCDE"}, new String[]{"FGHIJ"}, new int[]{-1}),
                Arguments.of(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","DG", "AABB"}, new int[]{9, -1, 4})
        );
    }
}