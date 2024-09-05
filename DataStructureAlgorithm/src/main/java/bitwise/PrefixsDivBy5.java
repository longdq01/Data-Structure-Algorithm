package bitwise;

import java.util.ArrayList;
import java.util.List;

public class PrefixsDivBy5 {
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int d = 0;
        for (int num : nums) {
            d = (2 * d % 5 + num) % 5;
            result.add(d == 0);
        }
        return result;
    }
}
