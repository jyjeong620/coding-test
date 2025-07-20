package yujin.week16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week16SolutionTest {
    private Week16Solution solution;

    @BeforeEach
    void setup() {
        solution = new Week16Solution();
    }

    @DisplayName("키패드 누르기")
    @ParameterizedTest
    @MethodSource("pushKeypadTestCases")
    void pushKeypad(int[] numbers, String hand, String expected) {
        // when & then
        assertThat(solution.pushKeypad(numbers, hand)).isEqualTo(expected);
    }

    public static Stream<Arguments> pushKeypadTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                        "right",
                        "LRLLLRLLRRL"
                ),
                Arguments.of(
                        new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                        "left",
                        "LRLLRRLLLRR"
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        "right",
                        "LLRLLRLLRL"
                )
        );
    }

    @DisplayName("성격 유형 검사하기")
    @ParameterizedTest
    @MethodSource("kakaotiTestCases")
    void kakaoti(String[] survey, int[] choices, String expected) {
        // when & then
        assertThat(solution.kakaoti(survey, choices)).isEqualTo(expected);
    }

    public static Stream<Arguments> kakaotiTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"AN", "CF", "MJ", "RT", "NA"},
                        new int[]{5, 3, 2, 7, 5},
                        "TCMA"
                ),
                Arguments.of(
                        new String[]{"TR", "RT", "TR"},
                        new int[]{7, 1, 3},
                        "RCJA"
                )
        );
    }

    @DisplayName("신규 아이디 추천")
    @ParameterizedTest
    @CsvSource({
            "...!@BaT#*..y.abcdefghijklm,bat.y.abcdefghi",
            "z-+.^.,z--",
            "=.=,aaa",
            "123_.def,123_.def",
            "abcdefghijklmn.p,abcdefghijklmn"
    })
    void recommendNewId(String newId, String expected) {
        // when & then
        assertThat(solution.recommendNewId(newId)).isEqualTo(expected);
    }
}