package yujin.week20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week20SolutionTest {
    private Week20Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Week20Solution();
    }

    @DisplayName("행렬의 덧셈")
    @ParameterizedTest
    @MethodSource("arraySumTestCases")
    void arraySum(int[][] arr1, int[][] arr2, int[][] expected) {
        // when
        int[][] result = solution.arraySum(arr1, arr2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> arraySumTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2}, {2, 3}},
                        new int[][]{{3, 4}, {5, 6}},
                        new int[][]{{4, 6}, {7, 9}}
                ),
                Arguments.of(
                        new int[][]{{1}, {2}},
                        new int[][]{{3}, {4}},
                        new int[][]{{4}, {6}}
                )
        );
    }

    @DisplayName("숫자 문자열과 영단어")
    @ParameterizedTest
    @CsvSource({
            "one4seveneight, 1478",
            "23four5six7, 234567",
            "2three45sixseven, 234567",
            "123, 123",
            "oneoneone, 111"
    })
    void convertEnglishToNumber(String s, int expected) {
        // when
        int result = solution.convertEnglishToNumber(s);

        // then
        assertThat(result).isEqualTo(expected);
    }
}