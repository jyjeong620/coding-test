package junyoung.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Week4SolutionTest {

    @DisplayName("김서방 찾기")
    @Test
    void findKim() {
        // given
        Week4Solution solution = new Week4Solution();
        String[] seoul = {"Jane", "Kim"};

        // when
        String actual = solution.findMrKim(seoul);

        // then
        assertThat(actual).isEqualTo("김서방은 1에 있다");
    }

}