package jinwoo.week11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("체육복")
    @Test
    void testWorkoutClothes() {
        // given
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        // when
        int result = solution.workoutClothes(n, lost, reserve);

        // then
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("모의고사")
    @Test
    void testMockTest() {
        // given
        int[] answers = {1, 3, 2, 4, 2};

        // when
        int[] result = solution.mockTest(answers);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("음양 더하기")
    @Test
    void testSumWithSigns() {
        // given
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        // when
        int result = solution.sumWithSigns(absolutes, signs);

        // then
        assertThat(result).isEqualTo(9);
    }


}