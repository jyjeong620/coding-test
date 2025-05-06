package jinwoo.week5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    Solution solution = new Solution();

    @DisplayName("명예의 전당")
    @Test
    void testTheHallOfFrame() {
        // given
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        // when
        int[] result = solution.theHallOfFrame(k, score);

        // then
        assertThat(result).isEqualTo(new int[]{10, 10, 10, 20, 20, 100, 100});
    }

    @DisplayName("기사단원의 무기")
    @Test
    void testKnightsWeapon() {
        // given
        int number = 10;
        int limit = 3;
        int power = 2;

        // when
        int result = solution.knightsWeapon(number, limit, power);

        // then
        assertThat(result).isEqualTo(21);
    }

    @DisplayName("과일장수")
    @Test
    void testFruitSeller() {
        // given
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        // when
        int result = solution.fruitSeller(k, m, score);

        // then
        assertThat(result).isEqualTo(8);
    }
}
