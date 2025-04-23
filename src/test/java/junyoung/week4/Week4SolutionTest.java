package junyoung.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
                {new int[]{1,2,3,4,5}, new int[]{1}},
                {new int[]{1,3,2,4,2}, new int[]{1,2,3}}
        };
    }
}