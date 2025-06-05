package jinwoo.week10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("약수의 개수와 덧셈")
    @Test
    void testSumWithDivisorCountRule() {
                // given
                int left = 13;
                int right = 17;
        
                // when
                int result = solution.sumWithDivisorCountRule(left, right);
        
                // then
                assertThat(result).isEqualTo(43);
    }

    @DisplayName("두개 뽑아서 더하기")
    @Test
    void testSumTwoPickedNumbers() {
        // given
        int[] input = {2, 1, 3, 4, 1};

        // when
        int[] result = solution.sumTwoPickedNumbers(input);

        // then
        assertThat(result).containsExactly(2, 3, 4, 5, 6, 7);
    
    }

    @DisplayName("실패율")
    @Test
    void testGetFailureRate() {
        // Given
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        // When
        int[] result = solution.getFailureRate(N, stages);

        // Then
        assertThat(result).isEqualTo(new int[]{3, 4, 2, 1, 5});
    }
}