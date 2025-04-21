package yujin.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("푸드 파이트 대회")
    @ParameterizedTest
    @CsvSource({"'1,3,4,6', 1223330333221", "'1,7,1,2', 111303111",})
    void speedEatingCompetition(String foodAsString, String expected) {
        // given
        Solution solution = new Solution();
        int[] food = Arrays.stream(foodAsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // when
        String result = solution.speedEatingCompetition(food);

        // then
        assertThat(result).isEqualTo(expected);
    }
}