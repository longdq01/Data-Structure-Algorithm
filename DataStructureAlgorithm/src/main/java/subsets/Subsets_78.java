package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int s = subsets.size();
            for (int j = 0; j < s; j++) {
                List<Integer> tmp = new ArrayList<>(subsets.get(j));
                tmp.add(num);
                subsets.add(tmp);
            }
        }
        return subsets;
    }
}
