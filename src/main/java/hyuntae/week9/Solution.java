package hyuntae.week9;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] bestAlbum(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();

        // 장르별 노래 목록 저장 (각 노래는 [고유번호, 재생횟수] 구조)
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            genreToSongs.putIfAbsent(genre, new ArrayList<>());
            genreToSongs.get(genre).add(new int[]{i, play});
        }

        // 장르를 총 재생수 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);

            // 각 장르 내의 노래를 재생 수 내림차순, 고유 번호 오름차순으로 정렬
            songs.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // 재생 수 내림차순
                return a[0] - b[0]; // 고유 번호 오름차순
            });

            // 최대 2곡 선택
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i)[0]);
            }
        }

        // List<Integer> → int[] 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int poncket(int[] nums) {
        int selectCount = nums.length / 2;
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
        return Math.min(set.size(), selectCount);
    }

    public boolean phoneBookList(String[] phone_book) {
        List<String> numbers = Arrays.stream(phone_book)
                .sorted()
                .toList();
        String now = "";
        for (String number: numbers) {
            if (isPrefix(now, number)) {
                return false;
            }
            now = number;
        }
        return true;
    }

    private static boolean isPrefix(String now, String next) {
        if (now.isEmpty()) {
            return false;
        }
        if (now.length() > next.length()) {
            return false;
        }
        if (next.substring(0, now.length()).equals(now)) {
            return true;
        }
        return false;
    }
}
