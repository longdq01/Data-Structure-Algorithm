package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> subsets = new ArrayList<>();
//        subsets.add(new ArrayList<>());
//        for (int num : nums) {
//            int s = subsets.size();
//            for (int j = 0; j < s; j++) {
//                List<Integer> tmp = new ArrayList<>(subsets.get(j));
//                tmp.add(num);
//                subsets.add(tmp);
//            }
//        }
//        return subsets;
//    }

    private int getBit(int num, int bit) {
        // shifts the first operand the specified number of bits to the left
        int temp = (1 << bit);

        // if binary number and current subset count are equal,
        // return 1 else return 0
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums.length != 0){
            int totalSubsets = (int) Math.pow(2, nums.length);

            for (int i = 0; i < totalSubsets; i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if(getBit(i, j) == 1){
                        int x = nums[j];
                        subset.add(x);
                    }
                }
                subsets.add(subset);
            }
        }else{
            subsets.add(new ArrayList<>());
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(2 & 5);
    }
}
