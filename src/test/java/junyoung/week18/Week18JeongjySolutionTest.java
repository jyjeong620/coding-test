package junyoung.week18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> gcdAndLcmProvider() {
        return Stream.of(
                Arguments.of(3, 12, new int[]{3, 12}),
                Arguments.of(2, 5, new int[]{1, 10})
        );
    }

}