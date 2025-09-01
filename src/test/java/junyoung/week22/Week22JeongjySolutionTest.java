package junyoung.week22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week22JeongjySolutionTest {
    private Week22JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week22JeongjySolution();
    }

    @DisplayName("로또의 최고 순위와 최저 순위")
    @ParameterizedTest
    @MethodSource("lottoProvider")
    void getLottoRanksTest(int[] lottos, int[] win_nums, int[] expected) {
        // given & when
        int[] actual = solution.getLottoRanks(lottos, win_nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> lottoProvider() {
        return Stream.of(
                Arguments.of(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}, new int[]{3, 5}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}, new int[]{1, 6}),
                Arguments.of(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}, new int[]{1, 1})
        );
    }

    @DisplayName("기사단원의 무기")
    @ParameterizedTest
    @CsvSource({
            "5, 3, 2, 10",
            "10, 3, 2, 21",
    })
    void weaponOfKnightTest(int number, int limit, int power, int expected) {
        // given & when
        int actual = solution.weaponOfKnight(number, limit, power);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("비밀지도")
    @ParameterizedTest
    @MethodSource("secretMapProvider")
    void secretMapTest(int n, int[] arr1, int[] arr2, String[] expected) {
        // given & when
        String[] actual = solution.secretMap(n, arr1, arr2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> secretMapProvider() {
        return Stream.of(
                Arguments.of(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}, new String[]{"#####", "# # #", "### #", "#  ##", "#####"}),
                Arguments.of(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}, new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "})
        );
    }
}