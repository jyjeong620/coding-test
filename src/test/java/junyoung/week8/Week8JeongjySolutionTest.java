package junyoung.week8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> keyboardProvider() {
        return Stream.of(
                Arguments.of(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"}, new int[]{9, 4}),
                Arguments.of(new String[]{"AA"}, new String[]{"B"}, new int[]{-1}),
                Arguments.of(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"}, new int[]{4, 6}),
                Arguments.of(new String[]{"ABCDE"}, new String[]{"FGHIJ"}, new int[]{-1}),
                Arguments.of(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "DG", "AABB"}, new int[]{9, -1, 4})
        );
    }

    @DisplayName("소수만들기")
    @ParameterizedTest
    @MethodSource("makePrimeNumberProvider")
    void makePrimeNumberTest(int[] nums, int expected) {
        // given
        Week8JeongjySolution solution = new Week8JeongjySolution();

        // when
        int actual = solution.makePrimeNumber(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> makePrimeNumberProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 1),
                Arguments.of(new int[]{1, 2, 7, 6, 4}, 4)

        );
    }

    @DisplayName("없는숫자더하기")
    @ParameterizedTest
    @MethodSource("plusEmptyNumberProvider")
    void plusEmptyNumber(int[] numbers, int expected) {
        // given
        Week8JeongjySolution solution = new Week8JeongjySolution();

        // when
        int actual = solution.plusEmptyNumber(numbers);

        // then
        assertThat(actual).isEqualTo(expected);

    }

    private static Stream<Arguments> plusEmptyNumberProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,6,7,8,0}, 14),
                Arguments.of(new int[]{5,8,4,0,6,7,9}, 6)
        );
    }
}