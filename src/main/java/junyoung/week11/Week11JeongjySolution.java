package junyoung.week11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Week11JeongjySolution {
    public String sortString(String s) {
        String[] splitString = s.split("");
        Arrays.sort(splitString, Comparator.reverseOrder());
        return String.join("", splitString);
    }

    public int dotProduct(int[] a, int[] b) {
        int totalNum = 0;
        for (int i = 0; i < a.length; i++) {
            totalNum += a[i] * b[i];
        }
        return totalNum;
    }

    public int dotProduct2(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
