package junyoung.week10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Week10JeongjySolution {
    public String[] sortByMyMind(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparing((String s) -> s.charAt(n))
                        .thenComparing(Function.identity()))
                .toArray(String[]::new);
    }
}
