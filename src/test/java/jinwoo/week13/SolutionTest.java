package jinwoo.week13;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("폰켓몬")
    @Test
    void testPocketMon() {
        // given
        int[] nums = {3, 3, 3, 2, 2, 4};

        // when
        int result = solution.pocketmon(nums);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("2016년")
    @Test
    void testYear2016() {
        // given
        int a = 5, b = 24;

        // when
        String result = solution.year2016(a, b);

        // then
        assertThat(result).isEqualTo("TUE");
    }

    @DisplayName("가운데 글자 가져오기")
    @Test
    void testMiddleChar() {
        // given
        String input = "abcd";

        // when
        String result = solution.middleChar(input);

        // then
        assertThat(result).isEqualTo("bc");
    }
    
}
