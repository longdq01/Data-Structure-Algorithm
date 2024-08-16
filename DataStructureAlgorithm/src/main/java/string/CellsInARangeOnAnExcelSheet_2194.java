package string;

import java.util.ArrayList;
import java.util.List;

public class CellsInARangeOnAnExcelSheet_2194 {
    public List<String> cellsInRange(String s) {
        int col1 = s.charAt(0) - 'A', col2 = s.charAt(3) - 'A';
        int rol1 = s.charAt(1) - '0', rol2 = s.charAt(4) - '0';
        ArrayList<String> res = new ArrayList<>();
        for (int i = col1; i <= col2; i++) {
            for (int j = rol1; j <= rol2; j++) {
                res.add(Character.toString(i + 'A') + j);
            }
        }
        return res;
    }
}
