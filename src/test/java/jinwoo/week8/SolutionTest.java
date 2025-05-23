package jinwoo.week8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @DisplayName("성격 유형 검사하기")
    @Test
    void personalityTypeCheckTest() {
        // given
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        // when
        String result = solution.personalityTypeCheck(survey, choices);

        // then
        assertThat(result).isEqualTo("TCMA");

    }

    @DisplayName("신고 결과 받기")
    @Test
    void getReportResultsTest() {
        // given
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        // when
        int[] result = solution.getReportResults(id_list, report, k);

        // then
        assertThat(result).isEqualTo(new int[]{2, 1, 1, 0});
    }

    @DisplayName("나머지가 1이 되는 수 찾기")
    @Test
    void testFindNumberWithRemainderOne() {
        // given
        int n = 10;

        // when
        int result = solution.findNumberWithRemainderOne(n);

        // then
        assertThat(result).isEqualTo(3);
    }
}
