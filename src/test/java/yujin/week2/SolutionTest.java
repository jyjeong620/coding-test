package yujin.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("짝수와 홀수")
    @ParameterizedTest
    @CsvSource({
            "3, Odd",
            "4, Even",
            "0, Even",
            "-3, Odd",
            "-4, Even"
    })
    void oddOrEven(int num, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.oddOrEven(num);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("평균 구하기")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4', 2.5",
            "'5,5', 5"
    })
    void average(String arrAsString, double expected) {
        // given
        Solution solution = new Solution();
        int[] arr = Arrays.stream(arrAsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // when
        double result = solution.average(arr);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("x만큼 간격이 있는 n개의 숫자")
    @ParameterizedTest
    @CsvSource({
            "2,5,'2,4,6,8,10'",
            "4,3,'4,8,12'",
            "-4,2,'-4,-8'"
    })
    void numberSequence(int x, int n, String expectedAsString) {
        // given
        Solution solution = new Solution();

        long[] expected = Arrays.stream(expectedAsString.split(","))
                .mapToLong(Long::parseLong)
                .toArray();

        // when
        long[] result = solution.numberSequence(x, n);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("추억 점수")
    @ParameterizedTest
    @MethodSource("memoryPointsTestCases")
    void memoryPoints(String[] name, int[] yearning, String[][] photo, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.memoryPoints(name, yearning, photo);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> memoryPointsTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{
                                {"may", "kein", "kain", "radi"},
                                {"may", "kein", "brin", "deny"},
                                {"kon", "kain", "may", "coni"}
                        },
                        new int[]{19, 15, 6}
                ),
                Arguments.of(
                        new String[]{"kali", "mari", "don"},
                        new int[]{11, 1, 55},
                        new String[][]{
                                {"kali", "mari", "don"},
                                {"pony", "tom", "teddy"},
                                {"con", "mona", "don"}
                        },
                        new int[]{67, 0, 55}
                ),
                Arguments.of(
                        new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{
                                {"may"},
                                {"kein", "deny", "may"},
                                {"kon", "coni"}
                        },
                        new int[]{5, 15, 0}
                )
        );
    }
}


