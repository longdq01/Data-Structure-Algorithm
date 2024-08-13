package backtracking;

import java.util.*;

public class CombinationSumII_40 {
    int sum = 0, n, target;
    int[] candidates;
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;
        backtracking(0);
        return results;
    }

    public void backtracking(int i){
        int prev = -1;
        for (int j = i; j < n; j++) {
            if(candidates[j] == prev)
                continue;
            prev = candidates[j];
            sum += candidates[j];
            if(sum > target){
                sum -= candidates[j];
                continue;
            }
            result.add(candidates[j]);
            if(sum == target){
                List<Integer> tmp = new ArrayList<>(result);
                if(!results.contains(tmp))
                    results.add(tmp);
            }else{
                backtracking(j + 1);
            }
            sum -= candidates[j];
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII_40 c = new CombinationSumII_40();
        System.out.println(c.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1}, 5));
    }
}
