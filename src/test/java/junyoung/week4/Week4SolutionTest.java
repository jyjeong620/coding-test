package junyoung.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


class Week4SolutionTest {

    @DisplayName("김서방 찾기")
    @Test
    void findKim() {
        // given
        Week4Solution solution = new Week4Solution();
        String[] seoul = {"Jane", "Kim"};

        // when
        String actual = solution.findMrKim(seoul);

        // then
        assertThat(actual).isEqualTo("김서방은 1에 있다");
    }

    @DisplayName("모의고사")
    @ParameterizedTest
    @MethodSource("mockExamProvider")
    void mockExam(int[] answers, int[] expected) {
        // given
        Week4Solution solution = new Week4Solution();

        // when
        int[] actual = solution.mockExam(answers);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[][] mockExamProvider() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{1}},
                {new int[]{1, 3, 2, 4, 2}, new int[]{1, 2, 3}}
        };
    }

    @DisplayName("숫자 짝궁")
    @ParameterizedTest
    @CsvSource({
            "100, 2345, -1",
            "100, 203045, 0",
            "100, 123450, 10",
            "12321, 42531, 321",
            "5525, 1255, 552"
    })
    void findFriend(String X, String Y, String expected) {
        // given
        Week4Solution solution = new Week4Solution();

        // when
        String actual = solution.findFriend(X, Y);

        assertThat(actual).isEqualTo(expected);
    }
}