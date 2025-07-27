package hyuntae.week17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @DisplayName("오픈채팅방")
    @ParameterizedTest
    @MethodSource("openChatRoomTestCases")
    void stringCompression(String[] record, String[] expected) {
        // given
        Solution solution = new Solution();

        // when
        String[] result = solution.openChatRoom(record);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] openChatRoomTestCases() {
        return new Object[][]{
                {new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}, new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}},
        };
    }

    @DisplayName("카펫")
    @ParameterizedTest
    @MethodSource("carpetTestCases")
    void carpet(int brown, int yellow, int[] expected) {
        // given
        Solution solution = new Solution();

        // when
        int[] result = solution.carpet(brown, yellow);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] carpetTestCases() {
        return new Object[][]{
                {10, 2, new int[]{4, 3}},
                {8, 1, new int[]{3, 3}},
                {24, 24, new int[]{8, 6}},
        };
    }

    @DisplayName("소수 찾기")
    @ParameterizedTest
    @MethodSource("findPrimeTestCases")
    void findPrime(String n, int expected) {
        // given
        Solution solution = new Solution();

        // when
        int result = solution.findPrime(n);
        // then
        assertThat(expected).isEqualTo(result);
    }

    private static Object[][] findPrimeTestCases() {
        return new Object[][]{
                {"17", 3},
                {"011", 2},
                {"0000", 0},
        };
    }
}