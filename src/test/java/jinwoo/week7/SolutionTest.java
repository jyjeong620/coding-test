package jinwoo.week7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("콜라문제")
    @Test
    void testCoke() {
        // given
        int a = 2;
        int b = 1;
        int n = 20;

        // when
        int result = solution.coke(a, b, n);

        // then
        assertThat(result).isEqualTo(19);
    }

    @DisplayName("삼총사")
    @Test
    void testTrio() {
        // Given
        int[] number = {-2, 3, 0, 2, -5};

        // When
        int result = solution.trio(number);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("숫자 짝꿍")
    @Test
    void testNumberPair() {
        // Given
        String X = "5525";
        String Y = "1255";

        // When
        String result = solution.numberPair(X, Y);

        // Then
        assertThat(result).isEqualTo("552");
    }
}
