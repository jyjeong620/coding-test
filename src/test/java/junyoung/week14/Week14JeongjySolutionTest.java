package junyoung.week14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week14JeongjySolutionTest {
    @DisplayName("체육복")
    @ParameterizedTest
    @MethodSource("physicalEducationKitProvider")
    void physicalEducationKitTest(int n, int[] lost, int[] reserve, int expected) {
        // given
        Week14JeongjySolution solution = new Week14JeongjySolution();

        // when
        int actual = solution.physicalEducationKit(n, lost, reserve);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> physicalEducationKitProvider() {
        return Stream.of(
                Arguments.of(5, new int[]{2, 4}, new int[]{1, 3, 5}, 5),
                Arguments.of(5, new int[]{2, 3}, new int[]{3, 4}, 4),
                Arguments.of(3, new int[]{3}, new int[]{1}, 2)
        );
    }

    @DisplayName("정수 내림차순으로 배치하기")
    @ParameterizedTest
    @CsvSource({"118372, 873211"})
    void sortNumberDescTest(long n, long expect) {
        // given
        Week14JeongjySolution solution = new Week14JeongjySolution();

        // when
        long actual = solution.sortNumberDesc(n);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("하샤드 수")
    @ParameterizedTest
    @CsvSource({
            "10, true",
            "11, false",
            "12, true",
            "13, false"
    })
    void isHarshadNumberTest(int n, boolean expected) {
        // given
        Week14JeongjySolution solution = new Week14JeongjySolution();

        // when
        boolean actual = solution.isHarshadNumber(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}