package jinwoo.week12;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("내적")
    @Test
    void testInnerProduct() {
        // given
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        // when
        int result = solution.innerProduct(a, b);

        // then
        assertThat(result).isEqualTo(32);
    }

    @DisplayName("완주하지 못한 선수")
    @Test
    void testFindIncompleteRunner() {
        // given
        String[] participant = {"leo", "leo", "kiki", "eden"};
        String[] completion = {"leo", "eden", "kiki"};
        String expected = "leo";

        // when
        String result = solution.findIncompleteRunner(participant, completion);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("예산")
    @Test
    void testBudget() {
        // given
        int[] requests = {1, 3, 2, 5, 4};
        int budget = 9;

        // when
        int supportedDepartments = solution.budget(requests, budget);
        
        // then
        assertThat(supportedDepartments).isEqualTo(3);
    }

    
}