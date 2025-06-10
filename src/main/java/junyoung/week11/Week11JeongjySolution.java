package junyoung.week11;

import java.util.Arrays;
import java.util.Comparator;

public class Week11JeongjySolution {
    public String sortString(String s) {
        String[] splitString = s.split("");
        Arrays.sort(splitString, Comparator.reverseOrder());
        return String.join("", splitString);
    }
}
