package hyuntae.week21;

import java.util.Arrays;

public class Solution {
    public int billFolding(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        while (!isInsertable(wallet, bill)) {
            fold(bill);
            answer++;
        }
        return answer;
    }

    private void fold(int[] bill) {
        bill[1] = bill[1] / 2;
        Arrays.sort(bill);
    }

    private boolean isInsertable(int[] wallet, int[] bill) {
        return wallet[0] >= bill[0] && wallet[1] >= bill[1];
    }

    private final String NEXT = "next";
    private final String PREV = "prev";

    private static int videoLen, opStart, opEnd;

    public String videoPlayer(String video_len, String pos, String op_start, String op_end, String[] commands) {
        initialize(video_len, op_start, op_end);
        int position = toSeconds(pos);
        position = skip(position);

        for (String command: commands) {
            position = commander(position, command);
            position = checkLength(position);
            position = skip(position);
        }
        return toString(position);
    }

    private String toString(int time) {
        int minute = time / 60;
        int second = time % 60;
        return String.format("%02d", minute) + ":" + String.format("%02d", second);
    }

    private int checkLength(int time) {
        if (0 >= time) {
            return 0;
        }
        if (videoLen <= time) {
            return videoLen;
        }
        return time;
    }

    private int skip(int time) {
        if (opStart <= time && opEnd >= time) {
            return opEnd;
        }
        return time;
    }

    private void initialize(String video_len, String op_start, String op_end) {
        videoLen = toSeconds(video_len);
        opStart = toSeconds(op_start);
        opEnd = toSeconds(op_end);
    }

    private int toSeconds(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private int commander(int time, String command) {
        switch(command) {
            case PREV: time -= 10;
                break;
            case NEXT: time += 10;
        }
        return time;
    }

    public String caesarCipher(String s, int n) { // 공백 : 32
        String answer = "";
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != ' ') {
                // 소문자 97 122
                int tmp = 0;
                if(arr[i] >= 'a' && arr[i] <= 'z') {
                    tmp = (int)arr[i] + n;
                    if(tmp > (int)'z') {
                        answer += String.valueOf((char)(tmp - 26));
                    } else {
                        answer += String.valueOf((char)tmp);
                    }
                }
                // 대문자 65 90
                if(arr[i] >= 'A' && arr[i] <= 'Z') {
                    tmp = (int)arr[i] + n;
                    if(tmp > (int)'Z') {
                        answer += String.valueOf((char)(tmp - 26));
                    } else {
                        answer += String.valueOf((char)tmp);
                    }
                }
            } else {
                answer += String.valueOf(arr[i]);
            }
        }

        return answer;
    }
}
