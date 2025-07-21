package junyoung.week16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week16JeongjySolutionTest {
    Week16JeongjySolution solution;

    @BeforeEach
    void setUp() {
        solution = new Week16JeongjySolution();
    }

    @DisplayName("JadenCase 문자열 만들기")
    @ParameterizedTest
    @CsvSource({
            "3people unFollowed me, 3people Unfollowed Me",
            "for the last week, For The Last Week",
            "' 3people unFollowed me', ' 3people Unfollowed Me'",
            "'  for the what 1what  ', '  For The What 1what  '"
    })
    void makeJadenCaseStringTest(String s, String expected) {
        // given & when
        String actual = solution.makeJadenCaseString(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("푸드파이터")
    @ParameterizedTest
    @MethodSource("foodFighterProvider")
    void foodFighterTest(int[] food, String expected) {
        // given & when
        String actual = solution.foodFighter(food);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> foodFighterProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 6}, "1223330333221"),
                Arguments.of(new int[]{1, 7, 1, 2}, "111303111")
        );
    }

    @DisplayName("가장 가까운 같은 글자")
    @ParameterizedTest
    @MethodSource("mostNearSameStringProvider")
    void mostNearSameStringTest(String s, int[] expected) {
        // given & when
        int[] actual = solution.mostNearSameString(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> mostNearSameStringProvider() {
        return Stream.of(
                Arguments.of("banana", new int[]{-1, -1, -1, 2, 2, 2}),
                Arguments.of("foobar", new int[]{-1, -1, 1, -1, -1, -1})
        );
    }
}