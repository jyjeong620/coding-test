package junyoung.week23;

import java.util.ArrayList;
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
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid column: " + column);
        }
    }

    public int plus(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return sum;
    }

    public String coverNumber(String phone_number) {
        String lastFour = phone_number.substring(phone_number.length() - 4);
        return "*".repeat(Math.max(0, phone_number.length() - 4)) + lastFour;
    }
}
