package junyoung.week15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week15JeongjySolutionTest {

    @DisplayName("정수 제곱근 판별")
    @ParameterizedTest
    @MethodSource("integerSquareRootDeterminationTestCases")
    void integerSquareRootDetermination(long n, long expected) {
        // given
        Week15JeongjySolution solution = new Week15JeongjySolution();

        // when
        long result = solution.getNextSquareOrMinusOne(n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> integerSquareRootDeterminationTestCases() {
        return Stream.of(
                Arguments.of(121L, 144L),
                Arguments.of(3L, -1L)
        );
    }
}