package hyuntae.week17;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String[] openChatRoom(String[] record) {

        Map<String,String> idNickMap = getFinalNickname(record);
        List<String> result = new ArrayList<>();

        for(String eachRecord: record) {
            if(eachRecord.charAt(0) == 'C') {
                continue;
            }

            String message = getMessage(idNickMap, eachRecord);
            result.add(message);
        }

        return result.toArray(String[]::new);
    }

    Map<String,String> getFinalNickname(String[] records) {

        Map<String,String> idNickMap = new HashMap<>();

        for(String record: records) {
            String[] splitedRecord = record.split(" ");
            if(splitedRecord[0].equals("Leave")) {
                continue;
            }
            idNickMap.put(splitedRecord[1], splitedRecord[2]);
        }

        return idNickMap;
    }

    String getMessage(Map<String,String> idNickMap, String record) {
        String[] splitedRecord = record.split(" ");
        String message = "";

        if(splitedRecord[0].equals("Enter")) {
            message = idNickMap.get(splitedRecord[1]) + "님이 들어왔습니다.";
        }
        if(splitedRecord[0].equals("Leave")) {
            message = idNickMap.get(splitedRecord[1]) + "님이 나갔습니다.";
        }

        return message;
    }

    public int[] carpet(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = yellow; i >= 1; i--) {
            if(yellow % i != 0) {
                continue;
            }
            int x = i;
            int y = yellow / i;
            if(brown == (x + y) * 2 + 4) {
                answer[0] = x + 2;
                answer[1] = y + 2;
                break;
            }
        }
        return answer;
    }

    private boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    private Set<Integer> getPrimes(int acc, List<Integer> numbers) {
        Set<Integer> primes = new HashSet<>();
        if(isPrime(acc)) primes.add(acc);

        for(int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }
        return primes;
    }

    public int findPrime(String nums) {
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return getPrimes(0, numbers).size();
    }
}
