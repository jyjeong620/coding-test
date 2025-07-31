package junyoung.week18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Week18JeongjySolutionTest {
    Week18JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week18JeongjySolution();
    }

    @DisplayName("최대공약수와 최소공배수")
    @ParameterizedTest
    @MethodSource("gcdAndLcmProvider")
    void GCDAndLCMTest(int n, int m, int[] expected) {
        // given & when
        int[] actual = solution.GCDAndLCM(n, m);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> gcdAndLcmProvider() {
        return Stream.of(
                Arguments.of(3, 12, new int[]{3, 12}),
                Arguments.of(2, 5, new int[]{1, 10})
        );
    }

    @DisplayName("삼총사")
    @ParameterizedTest
    @MethodSource("threeMusketeersProvider")
    void threeMusketeersTest(int[] number, int expected) {
        // given & when
        int actual = solution.threeMusketeers(number);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> threeMusketeersProvider() {
        return Stream.of(
                Arguments.of(new int[]{-2, 3, 0, 2, -5}, 2),
                Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, 5),
                Arguments.of(new int[]{-1, 1, -1, 1}, 0)
        );
    }

    @DisplayName("마법의 엘리베이터")
    @ParameterizedTest
    @CsvSource({
            "16, 6",
            "2554, 16"
    })
    void magicElevatorTest(int storey, int expected) {
        // given & when
        int actual = solution.magicElevator(storey);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}