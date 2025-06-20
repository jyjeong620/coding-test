package hyuntae.week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int ironDome(int[][] targets) {
        int cur = 0;
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < targets.length; i++) {
            if (cur <= targets[i][0]) {
                cur = targets[i][1];
                answer++;
            }
        }
        return answer;
    }

    private static class Task {
        private final String name;
        private final int start;
        private final int duration;

        Task(String name, int start, int duration) {
            this.name = name;
            this.start = start;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getStart() {
            return start;
        }

        public int calculateEndTime(int from) {
            return from + duration;
        }
    }

    public String[] proceedAssignment(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(plans, (o1, o2) -> toMin(o1[1]) - toMin(o2[1]));
        Stack<Task> stack = new Stack<>();
        int nowTime = toMin(plans[0][1]);

        for (int i = 0; i < plans.length; i++) {
            String[] now = plans[i];
            String nowName = now[0];
            int nowStart = toMin(now[1]);
            int nowDuration = Integer.parseInt(now[2]);

            while (!stack.isEmpty() && nowTime < nowStart) {
                Task task = stack.pop();
                int stackEndTime = task.calculateEndTime(nowTime);

                if (stackEndTime <= nowStart) {
                    answer.add(task.getName());
                    nowTime = stackEndTime;
                } else {
                    stack.push(new Task(task.getName(), task.getStart(), stackEndTime - nowStart));
                    nowTime = nowStart;
                    break;
                }
            }
            stack.push(new Task(nowName, nowStart, nowDuration));
            nowTime = nowStart;
        }

        while (!stack.isEmpty()) {
            Task task = stack.pop();
            answer.add(task.getName());
        }

        return answer.toArray(String[]::new);
    }

    private int toMin(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
