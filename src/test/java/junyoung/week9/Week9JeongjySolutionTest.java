package junyoung.week9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week9JeongjySolutionTest {

    @DisplayName("나누어 떨어지는 숫자 배열")
    @ParameterizedTest
    @MethodSource("divideProvider")
    void divideTest(int[] arr, int divisor, int[] expect) {
        // given
        Week9JeongjySolution solution = new Week9JeongjySolution();

        // when
        int[] actual = solution.divide(arr, divisor);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    public static Stream<Arguments> divideProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 9, 7, 10}, 5, new int[]{5, 10}),
                Arguments.of(new int[]{2, 36, 1, 3}, 1, new int[]{1, 2, 3, 36}),
                Arguments.of(new int[]{3, 2, 6}, 10, new int[]{-1})

        );
    }

}