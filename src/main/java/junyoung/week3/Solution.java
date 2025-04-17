package junyoung.week3;

import java.util.ArrayList;

public class Solution {
    public String recommendId(String newId) {
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String oneStep = newId.toLowerCase();
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String twoStep = oneStep.replaceAll("[^a-z0-9\\-_.]", "");
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String threeStep = twoStep.replaceAll("\\.{2,}", ".");
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String fourStep = threeStep.replaceAll("^[.]|[.]$", "");
        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String fiveStep = fourStep;
        if (fiveStep.isEmpty()) {
            fiveStep = "a";
        }
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String sixStep = fiveStep;
        if (sixStep.length() >= 16) {
            sixStep = sixStep.substring(0, 15);
        }
        if (sixStep.endsWith(".")) {
            sixStep = sixStep.substring(0, sixStep.length() - 1);
        }
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String sevenStep = sixStep;
        if (sevenStep.length() <= 2) {
            char lastChar = sevenStep.charAt(sevenStep.length() - 1);
            while (sevenStep.length() < 3) {
                sevenStep += lastChar;
            }
        }
        return sevenStep;
    }

    public String card(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        for (String word : goal) {
            if (i < cards1.length && word.equals(cards1[i])) {
                i++;
            } else if (j < cards2.length && word.equals(cards2[j])) {
                j++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public int[] hateSameNumbers(int[] arr) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                number.add(arr[i]);
            }
        }
        return number.stream().mapToInt(i -> i).toArray();
    }
}
