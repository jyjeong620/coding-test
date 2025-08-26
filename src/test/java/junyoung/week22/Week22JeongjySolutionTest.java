package junyoung.week22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
}