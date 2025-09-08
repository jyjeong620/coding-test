package junyoung.week23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week23JeongjySolutionTest {

    private Week23JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week23JeongjySolution();
    }

    @DisplayName("데이터분석")
    @ParameterizedTest
    @MethodSource("dataAnalysisProvider")
    void dataAnalysisTest(int[][] data, String ext, int val_ext, String sort_by, int[][] expect) {
        // given & when
        int[][] actual = solution.dataAnalysis(data, ext, val_ext, sort_by);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> dataAnalysisProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain", new int[][]{{3, 20300401, 10, 8}, {1, 20300104, 100, 80}}
                )
        );
    }

    @DisplayName("음양 더하기")
    @ParameterizedTest
    @MethodSource("plusProvider")
    void plusTest(int[] absolutes, boolean[] signs, int expect) {
        // given & when
        int actual = solution.plus(absolutes, signs);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> plusProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 7, 12}, new boolean[]{true, false, true}, 9),
                Arguments.of(new int[]{1, 2, 3}, new boolean[]{false, false, true}, 0)
        );
    }

    @DisplayName("핸드폰 번호 가리기")
    @ParameterizedTest
    @CsvSource({
            "01033334444, *******4444",
            "027778888, *****8888"
    })
    void coverNumberTest(String phone_number, String expect) {
        // given & when
        String actual = solution.coverNumber(phone_number);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}