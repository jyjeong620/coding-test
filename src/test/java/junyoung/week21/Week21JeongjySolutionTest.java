package junyoung.week21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week21JeongjySolutionTest {

    private Week21JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week21JeongjySolution();
    }

    @DisplayName("문자열 나누기")
    @ParameterizedTest
    @CsvSource({
            "banana, 3",
            "abracadabra, 6",
            "aaabbaccccabba, 3"
    })
    void splitStringTest(String s, int expected) {
        // given & when
        int actual = solution.splitString(s);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("완주하지 못한 선수")
    @ParameterizedTest
    @MethodSource("nonFinisherProvider")
    void nonFinisherTest(String[] participant, String[] completion, String expected) {
        // given & when
        String actual = solution.nonFinisher(participant, completion);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> nonFinisherProvider() {
        return Stream.of(
                Arguments.of(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}, "leo"),
                Arguments.of(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}, "vinko"),
                Arguments.of(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}, "mislav")
        );
    }
}