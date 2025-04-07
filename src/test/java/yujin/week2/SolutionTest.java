package yujin.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
            "-4,2,'-4,-8"
    })
    void numberSequence(long number, int size, String expectedAsString) {
        // given
        Solution solution = new Solution();

        long[] expected = Arrays.stream(expectedAsString.split(","))
                .mapToLong(Long::parseLong)
                .toArray();

        // when
        long[] result = solution.numberSequence(number, size);

        // then
        assertThat(result).isEqualTo(expected);
    }
}