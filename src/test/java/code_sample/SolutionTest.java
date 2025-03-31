package code_sample;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int[] input, int expected) {
        // Given
        Solution solution = new Solution();

        // When
        int result = solution.solution(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{5, 7, 8, 3}, 0)
        );
    }
}