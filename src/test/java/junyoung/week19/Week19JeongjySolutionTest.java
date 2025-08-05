package junyoung.week19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week19JeongjySolutionTest {
    private Week19JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week19JeongjySolution();
    }

    @DisplayName("추억점수")
    @ParameterizedTest
    @MethodSource("memoryScoreProvider")
    void memoryScoreTest(String[] name, int[] yearning, String[][] photo, int[] expected) {
        // given & when
        int[] actual = solution.memoryScore(name, yearning, photo);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> memoryScoreProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}},
                        new int[]{19, 15, 6}
                ),
                Arguments.of(
                        new String[]{"kali", "mari", "don"},
                        new int[]{11, 1, 55},
                        new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}},
                        new int[]{67, 0, 55}
                ),
                Arguments.of(
                        new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}},
                        new int[]{5, 15, 0}
                )
        );
    }

}