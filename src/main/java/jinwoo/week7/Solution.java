package jinwoo.week7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int coke(int a, int b, int n) {
        int answer = 0;
        int own = n;
        while(own >= a) {
            int giveCoke = own/a;
            int receiveCoke = giveCoke * b;
            int returnCoke = giveCoke * a ;
            answer += receiveCoke;
            own -= returnCoke;
            own += receiveCoke;
        }

        return answer;
    }

    public int trio(int[] number) {
            int answer = 0;
            for(int i = 0; i < number.length -2; i++) {
                for(int j = i + 1; j < number.length -1; j++) {
                    for(int k = j + 1; k < number.length; k++) {
                        if(number[i] + number[j] + number[k] == 0) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
    }

    public String numberPair(String X, String Y) {
        String answer = "";
        HashMap<Character, Integer> xMap = new HashMap<>();
        for(char x: X.toCharArray()) {
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        }
        List<String> common = new ArrayList<>();

        for(char y: Y.toCharArray()) {
            Integer commonNum = xMap.get(y);
            if(commonNum != null) {
                if(commonNum > 0) {
                    common.add(String.valueOf(y));
                    xMap.put(y, commonNum - 1);
                }
            }
        }

        if(common.size() == 0) {
            return "-1";
        }

        boolean allZero = common.stream().allMatch(it -> it.equals("0"));
        if(allZero) {
            return "0";
        }

        List<String> reverseNum = common.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        answer = reverseNum.stream().collect(Collectors.joining());

        return answer;
    }
}
