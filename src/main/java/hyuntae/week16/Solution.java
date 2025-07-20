package hyuntae.week16;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static final char[][] STRS = {
            "*+-".toCharArray(),
            "+-*".toCharArray(),
            "+*-".toCharArray(),
            "-+*".toCharArray(),
            "-*+".toCharArray(),
            "*-+".toCharArray()
    };

    static long max = 0;

    public long expressionMaximization(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        for(int i = 0; i < STRS.length; i++) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(tokens);
            for(int j = 0; j < STRS[i].length; j++) {
                char now = STRS[i][j];
                if(!tmp.contains(String.valueOf(now))) {
                    continue;
                }
                while(true) {
                    int index = tmp.indexOf(String.valueOf(now));
                    if(index == -1) { // 없다는 뜻
                        break;
                    }
                    String value = calculator(tmp.get(index - 1), tmp.get(index + 1), tmp.get(index));
                    tmp.remove(index);
                    tmp.remove(index);
                    tmp.set(index - 1, value);
                }
            }
            long result = Math.abs(Long.parseLong(tmp.get(0)));
            if(max < result) {
                max = result;
            }
        }


        return max;
    }

    String calculator(String n1, String n2, String s) {
        long result = 0;
        switch(s) {
            case "*": result = Long.parseLong(n1) * Long.parseLong(n2);
                break;
            case "-": result = Long.parseLong(n1) - Long.parseLong(n2);
                break;
            case "+": result = Long.parseLong(n1) + Long.parseLong(n2);
                break;
        }
        return String.valueOf(result);
    }

    static char[] proc;

    public int skillTree(String skill, String[] skill_trees) {
        int count = 0;
        this.proc = skill.toCharArray();
        for(int i = 0; i < skill_trees.length; i++) {
            if(isValid(skill_trees[i])) count++;
        }
        return count;
    }

    boolean isValid(String skill_trees) {
        boolean[] isUsed = new boolean[proc.length];
        for(int i = 0; i < skill_trees.length(); i++) {
            for(int j = 0; j < proc.length; j++) {
                if(skill_trees.charAt(i) == proc[j]) {
                    isUsed[j] = true;
                    if(j != 0 && !isUsed[j-1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int[] numbers;
    static int target;
    static int cnt;

    public int targetNumber(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    void dfs(int index, int sum) {
        // 탈출조건
        if(index == numbers.length) {
            if(sum == target) cnt++;
            return;
        }
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
