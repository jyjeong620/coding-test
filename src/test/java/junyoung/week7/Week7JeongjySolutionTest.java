package junyoung.week7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class Week7JeongjySolutionTest {

    @DisplayName("2016년")
    @ParameterizedTest
    @CsvSource({
            "1, 1, 'FRI'",
            "5, 24, 'TUE'",
    })
    void year2016Test(int month, int day, String expected) {
        // given
        Week7JeongjySolution solution = new Week7JeongjySolution();

        //when
        String actual = solution.year2016(month, day);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}