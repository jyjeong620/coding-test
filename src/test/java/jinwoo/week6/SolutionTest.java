package jinwoo.week6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    Solution solution = new Solution();

    @DisplayName("푸드 파이트 대회")
    @Test
    void testFoodFightContest() {
        // given
        int[] food = {1, 3, 4, 6};

        // when
        String result = solution.foodFightContest(food);

        // then
        assertThat(result).isEqualTo("1223330333221");
    }

    @DisplayName("햄버거 만들기")
    @Test
    void testMakeBurger() {
        // given
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        // when
        int result = solution.makeBurger(ingredient);

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("옹알이")
    @Test
    void testBabbling() {
        //given
        String[] babbling = new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        // When
        int result = solution.babbling(babbling);

        // Then
        assertThat(result).isEqualTo(2);
    }
}
