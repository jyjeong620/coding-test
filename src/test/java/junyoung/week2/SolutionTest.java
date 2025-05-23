package junyoung.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("짝수와 홀수")
    @ParameterizedTest
    @CsvSource({
            "1, Odd",
            "2, Even"
    })
    void evenOrOdd(int num, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String actual = solution.evenOrOdd(num);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("개인정보 수집 유효기간")
    @ParameterizedTest
    @MethodSource("getDestructionPersonalInfoTestCases")
    void getDestructionPersonalInfo(String today, String[] terms, String[] privacies, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] actual = solution.getDestructionPersonalInfo(today, terms, privacies);

        // then
        assertThat(actual).contains(expected);
    }

    private static Stream<Arguments> getDestructionPersonalInfoTestCases() {
        return Stream.of(
                Arguments.of("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}, new int[]{1, 3}),
                Arguments.of("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}, new int[]{1, 4, 5})
        );
    }

    @DisplayName("평균 구하기")
    @ParameterizedTest
    @MethodSource("averageTestCases")
    void average(int[] arr, double expected) {
        //given
        Solution solution = new Solution();

        //when
        double actual = solution.average(arr);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    private static Stream<Arguments> averageTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2.5),
                Arguments.of(new int[]{5, 5}, 5)
        );
    }
}