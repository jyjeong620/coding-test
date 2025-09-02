package junyoung.week23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Week23JeongjySolution {

    public int[][] dataAnalysis(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = getColumnIndex(ext);

        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }
        int sortIdx = getColumnIndex(sort_by);

        filtered.sort(Comparator.comparingInt(o -> o[sortIdx]));
        return filtered.toArray(new int[0][]);
    }

    private int getColumnIndex(String column) {
        switch (column) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("Invalid column: " + column);
        }
    }
}
