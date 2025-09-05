package yujin.week23;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week23SolutionTest {
    private Week23Solution solution = new Week23Solution();

    @DisplayName("귤 고르기")
    @ParameterizedTest
    @MethodSource("selectTangerineTestCases")
    void selectTangerine(int k, int[] tangerine, int expected) {
        assertThat(solution.selectTangerine(k, tangerine)).isEqualTo(expected);
    }

    static Stream<Arguments> selectTangerineTestCases() {
        return Stream.of(
                Arguments.of(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 3),
                Arguments.of(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 2),
                Arguments.of(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}, 1)
        );
    }

    @DisplayName("구명보트")
    @ParameterizedTest
    @MethodSource("savePeopleTestCases")
    void savePeople(int[] people, int limit, int expected) {
        assertThat(solution.savePeople(people, limit)).isEqualTo(expected);
    }

    static Stream<Arguments> savePeopleTestCases() {
        return Stream.of(
                Arguments.of(new int[]{70, 50, 80, 50}, 100, 3),
                Arguments.of(new int[]{70, 80, 50}, 100, 3)
        );
    }
}