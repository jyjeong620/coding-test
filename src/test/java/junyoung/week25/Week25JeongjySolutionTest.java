package junyoung.week25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Week25JeongjySolutionTest {
    private Week25JeongjySolution solution;

    @BeforeEach
    void init() {
        this.solution = new Week25JeongjySolution();
    }

    @DisplayName("전화번호 목록")
    @ParameterizedTest
    @MethodSource("phoneNumberProvider")
    void phoneNumber(String[] phone_book, boolean expected) {
        // given & when
        boolean actual = solution.phoneNumber(phone_book);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> phoneNumberProvider() {
        return Stream.of(
                Arguments.of(new String[]{"119", "97674223", "1195524421"}, false),
                Arguments.of(new String[]{"123", "456", "789"}, true),
                Arguments.of(new String[]{"12", "123", "1235", "567", "88"}, false)
        );
    }

    @DisplayName("영어 끝말잇기")
    @ParameterizedTest
    @MethodSource("englishRelayProvider")
    void englishRelay(int n, String[] words, int[] expected) {
        // given & when
        int[] actual = solution.englishRelay(n, words);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> englishRelayProvider() {
        return Stream.of(
                Arguments.of(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}, new int[]{3, 3}),
                Arguments.of(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}, new int[]{0, 0}),
                Arguments.of(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}, new int[]{1, 3})
        );
    }
}
