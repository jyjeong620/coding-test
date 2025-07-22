package junyoung.week17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week17JeongjySolutionTest {
    Week17JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week17JeongjySolution();
    }

    @DisplayName("달리기 경주")
    @ParameterizedTest
    @MethodSource({"runningProvider"})
    void runningTest(String[] players, String[] callings, String[] expected) {
        // given & when
        String[] actual = solution.running(players, callings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> runningProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"mumu", "soe", "poe", "kai", "mine"},
                        new String[]{"kai", "kai", "mine", "mine"},
                        new String[]{"mumu", "kai", "mine", "soe", "poe"}
                )
        );
    }
}