package junyoung.week9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("폰켓몬")
    @ParameterizedTest
    @MethodSource("phonekemonProvider")
    void phonekemonTest(int[] nums, int expect) {
        // given
        Week9JeongjySolution solution = new Week9JeongjySolution();

        // when
        int actual = solution.phonekemon(nums);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> phonekemonProvider() {
        return Stream.of(
                Arguments.of(new int[]{3,1,2,3}, 2),
                Arguments.of(new int[]{3,3,3,2,2,4}, 3),
                Arguments.of(new int[]{3,3,3,2,2,2}, 2)
        );
    }

    @DisplayName("두정수사이의합")
    @ParameterizedTest
    @CsvSource({
            "3,5,12",
            "3,3,3",
            "5,3,12"
    })
    void sumNumbersTest(int a, int b, int expect) {
        // given
        Week9JeongjySolution solution = new Week9JeongjySolution();

        // when
        long actual = solution.sumNumbers(a, b);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}