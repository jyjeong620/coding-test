package jinwoo.week9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("없는 숫자 더하기")
    @Test
    void sumOfMissingDigitsTest() {
        // given
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        // when
        int result = solution.sumOfMissingDigits(numbers);

        // then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("부족한 금액 계산하기")
    @Test
    void calculateShortfallTest() {
        // given
        int price = 3;
        int money = 100;
        int count = 4;

        // when
        long result = solution.calculateShortfall(price, money, count);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("로또 최고 순위와 최저 순위 구하기")
    @Test
    void calculateBestAndWorstLottoTest() {
        // given
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        // when
        int[] result = solution.calculateBestAndWorstLotto(lottos, winNums);

        // then
        assertThat(result).isEqualTo(new int[]{3, 5});
    }


}
