package junyoung.week16;

import java.util.StringJoiner;

public class Week16JeongjySolution {
    public String makeJadenCaseString(String s) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : s.toLowerCase().split(" ", -1)) {
            if (word.isEmpty()) {
                joiner.add("");
                continue;
            }
            String string = word.substring(0, 1).toUpperCase() + word.substring(1);
            joiner.add(string);
        }
        return joiner.toString();
    }
}
