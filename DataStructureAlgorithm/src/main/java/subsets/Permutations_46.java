package subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    List<List<Integer>> permutation = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        permute(0, nums.length, tmp);
        return permutation;
    }

    public void permute(int i, int n, List<Integer> nums){
        if(i == n - 1){
            permutation.add(nums);
            return;
        }

        for (int j = i; j < n; j++) {
            List<Integer> tmp = new ArrayList<>(nums);
            swap(tmp, i, j);
            permute(i + 1, n, tmp);
        }
    }

    public void swap(List<Integer> nums, int i, int j){
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
