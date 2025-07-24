package junyoung.week17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week17JeongjySolutionTest {
    Week17JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week17JeongjySolution();
    }

    @DisplayName("달리기 경주")
    @ParameterizedTest
    @MethodSource({"runningProvider"})
    void runningTest(String[] players, String[] callings, String[] expected) {
        // given & when
        String[] actual = solution.running(players, callings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> runningProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"mumu", "soe", "poe", "kai", "mine"},
                        new String[]{"kai", "kai", "mine", "mine"},
                        new String[]{"mumu", "kai", "mine", "soe", "poe"}
                )
        );
    }

    @DisplayName("가장 작은 수 제거하기")
    @ParameterizedTest
    @MethodSource({"smallestNumberRemoveProvider"})
    void smallestNumberRemoveTest(int[] arr, int[] expected) {
        // given & when
        int[] actual = solution.smallestNumberRemove(arr);

        // then
        assertThat(actual).isEqualTo(expected);
    }
    public static Stream<Arguments> smallestNumberRemoveProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2}),
                Arguments.of(new int[]{10}, new int[]{-1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4, 5})
        );
    }

    @DisplayName("귤고르기")
    @ParameterizedTest
    @MethodSource({"choiceMandarinProvider"})
    void choiceMandarinTest(int k, int[] tangerine, int expected) {
        // given & when
        int actual = solution.choiceMandarin(k, tangerine);

        // then
        assertThat(actual).isEqualTo(expected);
    }
    public static Stream<Arguments> choiceMandarinProvider() {
        return Stream.of(
                Arguments.of(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 3),
                Arguments.of(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 2),
                Arguments.of(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}, 1)
        );
    }
}