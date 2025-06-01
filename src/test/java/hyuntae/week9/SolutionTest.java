package hyuntae.week9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("베스트엘범")
    @ParameterizedTest
    @MethodSource("bestAlbumTestCases")
    void largestNumber(String[] genres, int[] plays, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.bestAlbum(genres, plays);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] bestAlbumTestCases() {
        return new Object[][]{
                {new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}, new int[]{4, 1, 3, 0}},
                {new String[]{"a", "b", "c"}, new int[]{100, 200, 300}, new int[]{2, 1, 0}},
                {new String[]{"rock", "pop"}, new int[]{1000, 2000}, new int[]{1, 0}},
                {new String[]{"jazz"}, new int[]{500}, new int[]{0}}
        };
    }

    @DisplayName("폰켓몬")
    @ParameterizedTest
    @MethodSource("poncketTestCases")
    void poncket(int[] nums, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.poncket(nums);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] poncketTestCases() {
        return new Object[][]{
                {new int[]{3, 1, 2, 3}, 2},
                {new int[]{3, 3, 3, 2, 2, 4}, 3},
                {new int[]{1, 1, 1, 1}, 1},
                {new int[]{1, 2, 3, 4}, 2},
                {new int[]{5, 5, 5, 5, 5}, 1}
        };
    }

    @DisplayName("전화번호 목록")
    @ParameterizedTest
    @MethodSource("phoneBookListTestCases")
    void phoneBookList(String[] phone_book, boolean expected) {
        // given
        Solution solution = new Solution();

        // when
        boolean result = solution.phoneBookList(phone_book);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Object[][] phoneBookListTestCases() {
        return new Object[][]{
                {new String[]{"119", "97674223", "1195524421"}, false},
                {new String[]{"123", "456", "789"}, true},
                {new String[]{"12", "123", "1235"}, false},
                {new String[]{"1", "2", "3"}, true},
                {new String[]{"12345", "1234", "123456"}, false}
        };
    }
}