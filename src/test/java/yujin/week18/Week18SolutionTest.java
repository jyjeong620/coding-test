package yujin.week18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week18SolutionTest {
    private Week18Solution solution;

    @BeforeEach
    void setup() {
        solution = new Week18Solution();
    }

    @DisplayName("개인정보 수집 유효기간")
    @ParameterizedTest
    @MethodSource("privacyExpirationDateTestCases")
    void privacyExpirationDate(String today, String[] terms, String[] privacies, int[] expected) {
        // when & then
        assertThat(solution.privacyExpirationDate(today, terms, privacies)).isEqualTo(expected);
    }

    public static Stream<Arguments> privacyExpirationDateTestCases() {
        return Stream.of(
                Arguments.of(
                        "2022.05.19",
                        new String[]{"A 6", "B 12", "C 3"},
                        new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"},
                        new int[]{1, 3}
                ),
                Arguments.of(
                        "2020.01.01",
                        new String[]{"Z 3", "D 5"},
                        new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"},
                        new int[]{1, 4, 5}
                ),
                Arguments.of(
                        "2020.01.02",
                        new String[]{"A 1", "B 11"},
                        new String[]{"2019.12.01 A", "2020.01.01 B"},
                        new int[]{1}
                )
        );
    }
}