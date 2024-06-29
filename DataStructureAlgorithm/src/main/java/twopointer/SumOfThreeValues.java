package twopointer;

import java.util.Arrays;

public class SumOfThreeValues {
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int j = 0; j < n - 2; j++) {
            int i = j + 1, k = n - 1;
            while(i < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target)
                    return true;
                else if(sum < target)
                    i++;
                else
                    k--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSumOfThree(new int[]{1,-1,0},-1));
    }
}
