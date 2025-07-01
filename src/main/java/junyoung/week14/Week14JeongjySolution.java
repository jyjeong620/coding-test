package junyoung.week14;

import java.util.Arrays;

public class Week14JeongjySolution {
    public int physicalEducationKit(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((k - 1 == reserve[j]) || (k + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
